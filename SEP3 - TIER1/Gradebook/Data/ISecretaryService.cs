using System.Threading.Tasks;
using WebApplication.NetworkPackages;

namespace WebApplication.Data
{
    public interface ISecretaryService
    {
        Task<NetworkPackage> CreateTeacher(string firstName, string lastName, string password);
        Task<NetworkPackage> EditTeacher(string id, string password);
        Task<NetworkPackage> DeleteTeacher(string id);
        //Task<NetworkPackage> CreateStudent(string firstName, string lastName, string email, string password);
    }
}