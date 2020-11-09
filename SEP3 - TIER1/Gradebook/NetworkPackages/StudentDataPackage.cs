using WebApplication.Models;

namespace WebApplication.NetworkPackages
{
    public class StudentDataPackage : NetworkPackage
    {
        private Student data;
        
        public StudentDataPackage(NetworkType networkType, Student data, long id) : base(networkType, id)
        {
            this.data = data;
        }
        
        public Student getData()
        {
            return this.data;
        }
    }
}