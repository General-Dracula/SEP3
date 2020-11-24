using System;
using System.Net;
using System.Net.Http;
using System.Text.Json;
using System.Threading.Tasks;
using WebApplication.NetworkPackages;

namespace WebApplication.Data
{
    public class TeacherService : ITeacherService
    {
        public async Task<NetworkPackage> AssignGrade(string studentID, string course, int grade, string teacherID)
        {
            HttpClient client = new HttpClient();
            HttpResponseMessage response = await client.GetAsync(
                "http://localhost:" + Startup.PORT + $"/teachers/assigngrade?studentID={studentID}&course={course}&grade={grade}&teacherID={teacherID}");

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
            HttpResponseMessage response = await client.GetAsync(
                $"http://localhost:" + Startup.PORT + $"/teachers/assignabsence?studentID={studentID}&course={course}&teacherID={teacherID}");
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

        public async Task<NetworkPackage> MotivateAbsence(string studentID, string course, string date,
            string teacherID)
        {
            HttpClient client = new HttpClient();
            HttpResponseMessage response = await client.GetAsync(
                $"http://localhost:" + Startup.PORT + $"/teachers/motivateabsence?studentID={studentID}&course={course}&date={date}&teacherID={teacherID}");
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