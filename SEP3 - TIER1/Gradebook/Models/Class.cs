using System.Collections.Generic;

namespace WebApplication.Models
{
    public class Class
    {
        public int Year { get; set; }
        public char Letter { get; set; }
        public string TeacherID { get; set; }
        public List<Student> Students { get; set; }
        
        public List<Course> Courses { get; set; }
    }
}