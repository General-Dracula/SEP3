using System;
using System.Collections.Generic;

namespace WebApplication.Models
{
    public class Student 
    {
        public string Id { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public string Address { get; set; }
        public string Birthday { get; set; }
        public string Password { get; set; }
        public string PhoneNumber { get; set; }
        public List<Grade> Grades { get; set; }
        public List<Absence> Absences { get; set; }
    }
}