using WebApplication.Models;

namespace WebApplication.NetworkPackages
{
    public class StudentDataPackage : NetworkPackage
    {
        public Student data { get; set; }
    }
}