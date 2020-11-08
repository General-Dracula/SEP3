using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Text.Json;
using System.Threading.Tasks;
using WebApplication.Models;

namespace WebApplication.Data {
public class UserService : IUserService {
    private List<User> users;
    
    public UserService() {
        users = new[] {
            new User {
                Password = "123456",
                UserName = "AdminLevel2",
                SecurityLevel = 2
            },
            new User {
                Password = "123456",
                UserName = "AdminLevel1",
                SecurityLevel = 1
            },
            new User {
                Password = "1",
                UserName = "1",
                SecurityLevel = 2
            }
        }.ToList();
    }
    
    
    public async Task<User> ValidateLoginAsync(string username, string password)
    {
        HttpClient client = new HttpClient();
        HttpResponseMessage response = await client.GetAsync($"http://localhost:8081/users?username={username}&password={password}");
        if (response.StatusCode == HttpStatusCode.OK)
        {
            string userAsJson = await response.Content.ReadAsStringAsync();
            User resultUser = JsonSerializer.Deserialize<User>(userAsJson);
            Console.WriteLine(resultUser.UserName + " " + resultUser.Password + " " + resultUser.SecurityLevel);
            return resultUser;
        } 
        throw new Exception("User not found");
    }
    
    //For local testing purposes
    public User ValidateLogin(string userName, string password) {
        User first = users.FirstOrDefault(user => user.UserName.Equals(userName));
        if (first == null) {
            throw new Exception("User not found");
        }

        if (!first.Password.Equals(password)) {
            throw new Exception("Incorrect password");
        }

        return first;
    }
}
}