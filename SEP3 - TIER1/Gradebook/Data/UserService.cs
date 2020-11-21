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
        HttpResponseMessage response = await client.PostAsync("http://localhost:8080/users", content);
        if (response.StatusCode == HttpStatusCode.OK)
        {
            string userAsJson = await response.Content.ReadAsStringAsync();
            return userAsJson;
        } else throw new Exception("User not found");
    }

    public async Task<NetworkPackage> AssignGrade(string studentID, string course, int grade, string teacherID)
    {
        HttpClient client = new HttpClient();
        HttpResponseMessage response = await client.GetAsync($"http://localhost:8080/teachers/assigngrade?studentID={studentID}&course={course}&grade={grade}&teacherID={teacherID}");
        if (response.StatusCode == HttpStatusCode.OK)
        {
            string userAsJson = await response.Content.ReadAsStringAsync();
            TeacherDataPackage resultUser = JsonSerializer.Deserialize<TeacherDataPackage>(userAsJson);
            Console.WriteLine(resultUser.ToString());
            return resultUser;
        }   
        return null;
        throw new Exception("User not found");
    }

    public async Task<NetworkPackage> AssignAbsence(string studentID, string course, string teacherID)
    {
        HttpClient client = new HttpClient();
        HttpResponseMessage response = await client.GetAsync($"http://localhost:8080/teachers/assignabsence?studentID={studentID}&course={course}&teacherID={teacherID}");
        if (response.StatusCode == HttpStatusCode.OK)
        {
            string userAsJson = await response.Content.ReadAsStringAsync();
            TeacherDataPackage resultUser = JsonSerializer.Deserialize<TeacherDataPackage>(userAsJson);
            Console.WriteLine(resultUser.ToString());
            return resultUser;
        }   
        return null;
        throw new Exception("User not found");
    }
}
}