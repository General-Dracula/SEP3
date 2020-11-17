using System.Collections.Generic;

namespace WebApplication.Models
{
    public class Teacher
    {
        public string id { get; set; }
        public string firstName { get; set; }
        public string lastName { get; set; }
        public string password { get; set; }
        public List<Class> classes { get; set; }
    }
}