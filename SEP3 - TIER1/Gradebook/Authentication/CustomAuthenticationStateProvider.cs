using System;
using System.Collections.Generic;
using System.Security.Claims;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Components.Authorization;
using Microsoft.JSInterop;
using Newtonsoft.Json;
using WebApplication.Data;
using WebApplication.Models;
using WebApplication.NetworkPackages;
using JsonSerializer = System.Text.Json.JsonSerializer;

namespace WebApplication.Authentication {
public class CustomAuthenticationStateProvider : AuthenticationStateProvider {
    private readonly IJSRuntime jsRuntime;
    private readonly IUserService userService;

    private User cachedUser;

    public CustomAuthenticationStateProvider(IJSRuntime jsRuntime, IUserService userService) {
        this.jsRuntime = jsRuntime;
        this.userService = userService;
    }

    public override async Task<AuthenticationState> GetAuthenticationStateAsync() {
        var identity = new ClaimsIdentity();
        if (cachedUser == null) {
            string userAsJson = await jsRuntime.InvokeAsync<string>("sessionStorage.getItem", "currentUser");
            if (!string.IsNullOrEmpty(userAsJson)) {
                cachedUser = JsonSerializer.Deserialize<User>(userAsJson);

                identity = SetupClaimsForUser(cachedUser);
            }
        } else {
            identity = SetupClaimsForUser(cachedUser);
        }

        ClaimsPrincipal cachedClaimsPrincipal = new ClaimsPrincipal(identity);
        return await Task.FromResult(new AuthenticationState(cachedClaimsPrincipal));
    }

    public async Task ValidateLogin(string username, string password) {
        Console.WriteLine("Validating log in");
        if (string.IsNullOrEmpty(username)) throw new Exception("Enter username");
        if (string.IsNullOrEmpty(password)) throw new Exception("Enter password");

        ClaimsIdentity identity = new ClaimsIdentity();
        try
        {
            string response = await userService.ValidateLoginAsync(username, password);
            Console.WriteLine(response);
            NetworkPackage resultUser = JsonConvert.DeserializeObject<NetworkPackage>(response);
            Console.WriteLine(resultUser.id);
            User user = new User();
            //Console.WriteLine(resultUser.GetType().ToString() + "!!!!!!!!!-------------1");
            if (resultUser.type.Equals("StudentWindowData"));
            {
                //Console.WriteLine("!!!!!!!!!------------2");
                StudentDataPackage studentDataPackage = JsonSerializer.Deserialize<StudentDataPackage>(response);
                //Console.WriteLine(studentDataPackage.id.ToString() + "!!!!!!!!!------------3");
                user.UserName = studentDataPackage.data.id;
                //Console.WriteLine("!!!!!!!!!------------4");
                user.Password =  studentDataPackage.data.viewGradePassword;
                user.SecurityLevel = 2;    
                //Console.WriteLine("!!!!!!!!!------------5");
            }
            
            identity = SetupClaimsForUser(user);
            string serialisedData = JsonSerializer.Serialize(user);
            await jsRuntime.InvokeVoidAsync("sessionStorage.setItem", "currentUser", serialisedData);
            cachedUser = new User();
        } catch (Exception e) {
            Console.WriteLine(e.StackTrace);
            throw e;
        }

        NotifyAuthenticationStateChanged(
            Task.FromResult(new AuthenticationState(new ClaimsPrincipal(identity))));
    }

    public void Logout() {
        cachedUser = null;
        var user = new ClaimsPrincipal(new ClaimsIdentity());
        jsRuntime.InvokeVoidAsync("sessionStorage.setItem", "currentUser", "");
        NotifyAuthenticationStateChanged(Task.FromResult(new AuthenticationState(user)));
    }

    private ClaimsIdentity SetupClaimsForUser(User user) {
        List<Claim> claims = new List<Claim>();
        claims.Add(new Claim(ClaimTypes.Name, user.UserName));
        claims.Add(new Claim("Level", user.SecurityLevel.ToString()));

        ClaimsIdentity identity = new ClaimsIdentity(claims, "apiauth_type");
        return identity;
    }
}
}