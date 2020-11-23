using System.Threading.Tasks;
using WebApplication.NetworkPackages;

namespace WebApplication.Data
{
    public interface ITeacherService
    {
        Task<NetworkPackage> AssignGrade(string studentID, string course, int grade, string teacherID);
        Task<NetworkPackage> AssignAbsence(string studentID, string course, string teacherID);
        Task<NetworkPackage> MotivateAbsence(string studentID, string course, string date, string teacherID);
    }
}