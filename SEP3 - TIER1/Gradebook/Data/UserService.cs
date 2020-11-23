using System;
using System.Net;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using WebApplication.NetworkPackages;
using JsonSerializer = System.Text.Json.JsonSerializer;

namespace WebApplication.Data {
public class UserService : IUserService {
    public async Task<string> ValidateLoginAsync(string username, string password)
    {
        HttpClient client = new HttpClient();
        TwoFieldPackage userToVerify = new TwoFieldPackage{firstField = username, secondField = password};
        string userSerialized = JsonSerializer.Serialize(userToVerify);
        StringContent content = new StringContent(userSerialized, Encoding.UTF8, "application/json");
        HttpResponseMessage response = await client.PostAsync("http://localhost:" + Startup.PORT + "/users", content);
        if (response.StatusCode == HttpStatusCode.OK)
        {
            string userAsJson = await response.Content.ReadAsStringAsync();
            return userAsJson;
        } else throw new Exception("User not found");
    }
}
}