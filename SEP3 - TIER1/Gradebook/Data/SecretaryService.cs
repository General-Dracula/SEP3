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
            HttpClient client = new HttpClient();
            HttpResponseMessage response = await client.GetAsync(
                "http://localhost:" + Startup.PORT + $"/secretary/createteacher?firstName={firstName}&lastName={lastName}&password={password}");

            if (response.StatusCode == HttpStatusCode.OK)
            {
                string userAsJson = await response.Content.ReadAsStringAsync();
                SecretaryDataPackage resultUser = JsonSerializer.Deserialize<SecretaryDataPackage>(userAsJson);
                Console.WriteLine(resultUser.ToString());
                return resultUser;
            }

            return null;
        }

        public async Task<NetworkPackage> EditTeacher(string id, string password)
        {
            HttpClient client = new HttpClient();
            HttpResponseMessage response = await client.GetAsync(
                "http://localhost:" + Startup.PORT + $"/secretary/editteacher?id={id}&password={password}");

            if (response.StatusCode == HttpStatusCode.OK)
            {
                string userAsJson = await response.Content.ReadAsStringAsync();
                SecretaryDataPackage resultUser = JsonSerializer.Deserialize<SecretaryDataPackage>(userAsJson);
                Console.WriteLine(resultUser.ToString());
                return resultUser;
            }

            return null;
        }

        public async Task<NetworkPackage> DeleteTeacher(string id)
        {
            HttpClient client = new HttpClient();
            HttpResponseMessage response = await client.GetAsync(
                "http://localhost:" + Startup.PORT + $"/secretary/deleteteacher?id={id}");

            if (response.StatusCode == HttpStatusCode.OK)
            {
                string userAsJson = await response.Content.ReadAsStringAsync();
                SecretaryDataPackage resultUser = JsonSerializer.Deserialize<SecretaryDataPackage>(userAsJson);
                Console.WriteLine(resultUser.ToString());
                return resultUser;
            }

            return null;
        }
    }
}