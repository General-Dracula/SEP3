using System.Threading.Tasks;
using WebApplication.NetworkPackages;

namespace WebApplication.Data
{
    public interface ISecretaryService
    {
        Task<NetworkPackage> CreateTeacher(string firstName, string lastName, string password);
        Task<NetworkPackage> EditTeacher(string id, string password);
        Task<NetworkPackage> DeleteTeacher(string id);
        Task<NetworkPackage> CreateStudent(string firstName, string lastName, string address, string password, string phoneNr, string birthday);
        Task<NetworkPackage> EditStudent(string id, string address, string password, string phoneNr);
        Task<NetworkPackage> DeleteStudent(string id);
        Task<NetworkPackage> CreateClass(string classNr, string classLetter, string teacherId);
        Task<NetworkPackage> DeleteClass(string classLetter, string classNr);
        Task<NetworkPackage> AddStudentToClass(string classLetter, string classNr, string studentId);
        Task<NetworkPackage> RemoveStudentFromClass(string classLetter, string classNr, string studentId);
        Task<NetworkPackage> AddCourseToClass(string classLetter, string classNr, string courseName);
        Task<NetworkPackage> RemoveCourseFromClass(string classLetter, string classNr, string courseName);
        Task<NetworkPackage> ChangeSecretaryPassword(string newPassword);
        Task<NetworkPackage> ChangeSecretaryUsername(string newUsername);
    }
}