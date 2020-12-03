using System.Collections.Generic;

namespace WebApplication.Models
{
    public class Teacher
    {
        public string Id { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public string Password { get; set; }
        public List<Class> Classes { get; set; }
    }
}