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
            string URI = "http://localhost:" + Startup.PORT + $"/teachers/assigngrade?studentID={studentID}&course={course}&grade={grade}&teacherID={teacherID}";
            return await GetRequest(URI);
        }

        public async Task<NetworkPackage> AssignAbsence(string studentID, string course, string teacherID)
        {
            string URI = "http://localhost:" + Startup.PORT + $"/teachers/assignabsence?studentID={studentID}&course={course}&teacherID={teacherID}";
            return await GetRequest(URI);
        }

        public async Task<NetworkPackage> MotivateAbsence(string studentID, string course, string date,
            string teacherID)
        {
            string URI = "http://localhost:" + Startup.PORT + $"/teachers/motivateabsence?studentID={studentID}&course={course}&date={date}&teacherID={teacherID}";
            return await GetRequest(URI);
        }
        
        private async Task<NetworkPackage> GetRequest(string URI)
        {
            HttpClient client = new HttpClient();
            HttpResponseMessage response = await client.GetAsync(URI);

            if (response.StatusCode == HttpStatusCode.OK)
            {
                string responseAsJson = await response.Content.ReadAsStringAsync();
                TeacherDataPackage result = JsonSerializer.Deserialize<TeacherDataPackage>(responseAsJson);
                Console.WriteLine(result.ToString());
                return result;
            }
            return null;
        }
    }
}