using System.Collections.Generic;

namespace WebApplication.Models
{
    public class Class
    {
        public int year { get; set; }
        public char letter { get; set; }
        public string teacherID { get; set; }
        public List<Student> students { get; set; }
        
        public List<Course> courses { get; set; }
    }
}