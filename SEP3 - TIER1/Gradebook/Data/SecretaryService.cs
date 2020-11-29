using System;
using System.Net;
using System.Net.Http;
using System.Text.Json;
using System.Threading.Tasks;
using WebApplication.NetworkPackages;

namespace WebApplication.Data
{
    public class SecretaryService : ISecretaryService
    {
        public async Task<NetworkPackage> CreateTeacher(string firstName, string lastName, string password)
        {
            string URI = "http://localhost:" + Startup.PORT +
                         $"/secretary/createteacher?firstName={firstName}&lastName={lastName}&password={password}";
            return await GetRequest(URI);
        }

        public async Task<NetworkPackage> EditTeacher(string id, string password)
        {
            string URI = "http://localhost:" + Startup.PORT + $"/secretary/editteacher?id={id}&password={password}";
            return await GetRequest(URI);
        }

        public async Task<NetworkPackage> DeleteTeacher(string id)
        {
            string URI = "http://localhost:" + Startup.PORT + $"/secretary/deleteteacher?id={id}";
            return await GetRequest(URI);
        }

        public async Task<NetworkPackage> CreateStudent(string firstName, string lastName, string address,
            string password, string phoneNr, string birthday)
        {
            string URI = "http://localhost:" + Startup.PORT +
                         $"/secretary/createstudent?firstName={firstName}&lastName={lastName}&address={address}&password={password}&phoneNr={phoneNr}&birthday={birthday}";
            return await GetRequest(URI);
        }

        public async Task<NetworkPackage> EditStudent(string studentId, string address, string password, string phoneNr)
        {
            string URI = "http://localhost:" + Startup.PORT +
                         $"/secretary/editstudent?studentId={studentId}&address={address}&password={password}&phoneNr={phoneNr}";
            return await GetRequest(URI);
        }

        public async Task<NetworkPackage> DeleteStudent(string id)
        {
            string URI = "http://localhost:" + Startup.PORT + $"/secretary/deletestudent?id={id}";
            return await GetRequest(URI);
        }

        public async Task<NetworkPackage> CreateClass(string classNr, string classLetter, string teacherId)
        {
            string URI = "http://localhost:" + Startup.PORT +
                         $"/secretary/createclass?classNr={classNr}&classLetter={classLetter}&teacherId={teacherId}";
            return await GetRequest(URI);
        }

        public async Task<NetworkPackage> DeleteClass(string classLetter, string classNr)
        {
            string URI = "http://localhost:" + Startup.PORT +
                         $"/secretary/deleteclass?classLetter={classLetter}&classNr={classNr}";
            return await GetRequest(URI);
        }

        public async Task<NetworkPackage> AddStudentToClass(string classLetter, string classNr, string studentId)
        {
            string URI = "http://localhost:" + Startup.PORT +
                         $"/secretary/addstudent?classLetter={classLetter}&classNr={classNr}&studentId={studentId}";
            return await GetRequest(URI);
        }

        public async Task<NetworkPackage> RemoveStudentFromClass(string classLetter, string classNr, string studentId)
        {
            string URI = "http://localhost:" + Startup.PORT +
                         $"/secretary/removestudent?classLetter={classLetter}&classNr={classNr}&studentId={studentId}";
            return await GetRequest(URI);
        }

        public async Task<NetworkPackage> AddCourseToClass(string classLetter, string classNr, string courseName)
        {
            string URI = "http://localhost:" + Startup.PORT +
                         $"/secretary/addcourse?classLetter={classLetter}&classNr={classNr}&courseName={courseName}";
            return await GetRequest(URI);
        }

        public async Task<NetworkPackage> RemoveCourseFromClass(string classLetter, string classNr, string courseName)
        {
            string URI = "http://localhost:" + Startup.PORT +
                         $"/secretary/removecourse?classLetter={classLetter}&classNr={classNr}&courseName={courseName}";
            return await GetRequest(URI);
        }

        private async Task<NetworkPackage> GetRequest(string URI)
        {
            HttpClient client = new HttpClient();
            HttpResponseMessage response = await client.GetAsync(URI);

            if (response.StatusCode == HttpStatusCode.OK)
            {
                string responseAsJson = await response.Content.ReadAsStringAsync();
                SecretaryDataPackage result = JsonSerializer.Deserialize<SecretaryDataPackage>(responseAsJson);
                Console.WriteLine(result.ToString());
                return result;
            }

            return null;
        }
    }
}