using System.Threading.Tasks;
using WebApplication.Models;
using WebApplication.NetworkPackages;

namespace WebApplication.Data {
public interface IUserService
{
    Task<string> ValidateLoginAsync(string username, string password);
    Task<NetworkPackage> AssignGrade(string studentID, string course, int grade, string teacherID);
    Task<NetworkPackage> AssignAbsence(string studentID, string course, string teacherID);
}
}