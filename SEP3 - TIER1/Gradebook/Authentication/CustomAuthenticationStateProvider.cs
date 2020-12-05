using System;
using System.Collections.Generic;
using System.Security.Claims;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Components.Authorization;
using Microsoft.JSInterop;
using WebApplication.Data;
using WebApplication.Models;
using WebApplication.NetworkPackages;
using JsonSerializer = System.Text.Json.JsonSerializer;

namespace WebApplication.Authentication {
public class CustomAuthenticationStateProvider : AuthenticationStateProvider {
    private readonly IJSRuntime jsRuntime;
    private readonly IUserService userService;

    private User cachedUser;
    public static Student CachedStudent;
    public static Teacher CachedTeacher;
    public static Secretary CachedSecretary;

    private static bool studentWindow;
    private static bool teacherWindow;
    private static bool secretaryWindow;
    
    public CustomAuthenticationStateProvider(IJSRuntime jsRuntime, IUserService userService) {
        this.jsRuntime = jsRuntime;
        this.userService = userService;
        RestoreWindowBooleans();
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
        if (string.IsNullOrEmpty(username)) throw new Exception("Enter ID");
        if (string.IsNullOrEmpty(password)) throw new Exception("Enter password");

        ClaimsIdentity identity = new ClaimsIdentity();
        try
        {
            string response = await userService.ValidateLoginAsync(username, password);
            NetworkPackage resultUser = JsonSerializer.Deserialize<NetworkPackage>(response);
            User user = new User();
            if (resultUser.type.Equals("StudentData"))
            {
                StudentDataPackage studentDataPackage = JsonSerializer.Deserialize<StudentDataPackage>(response);
                user.UserName = studentDataPackage.data.Id;
                user.Password =  studentDataPackage.data.Password;
                user.SecurityLevel = 1;
                CachedStudent = studentDataPackage.data;
                RestoreWindowBooleans();
                studentWindow = true;
            } else if (resultUser.type.Equals("TeacherData"))
            {
                TeacherDataPackage teacherDataPackage = JsonSerializer.Deserialize<TeacherDataPackage>(response);
                user.UserName = teacherDataPackage.data.Id;
                user.Password =  teacherDataPackage.data.Password;
                user.SecurityLevel = 2;
                CachedTeacher = teacherDataPackage.data;
                RestoreWindowBooleans();
                teacherWindow = true;
            } else if (resultUser.type.Equals("SecretaryData"))
            {
                SecretaryDataPackage secretaryDataPackage = JsonSerializer.Deserialize<SecretaryDataPackage>(response);
                user.UserName = secretaryDataPackage.data.Id;
                user.Password = secretaryDataPackage.data.Password;
                user.SecurityLevel = 3;
                CachedSecretary = secretaryDataPackage.data;
                RestoreWindowBooleans();
                secretaryWindow = true;
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

    public static string NavigateToWindow()
    {
        if (studentWindow) return "/Student";
        else if (teacherWindow) return "/Teacher";
        else return "/SecretaryTeacher";
    }

    private void RestoreWindowBooleans()
    {
        studentWindow = false;
        teacherWindow = false;
        secretaryWindow = false;
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