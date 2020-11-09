using System;
using System.Collections.Generic;

namespace WebApplication.Models
{
    public class Student 
    {
        public string id { get; set; }
        public string firstName { get; set; }
        public string lastName { get; set; }
        public string address { get; set; }
        public string birthday { get; set; }
        public string viewGradePassword { get; set; }
        public string phoneNumber { get; set; }
        public List<Grade> grades { get; set; }
        public List<Absence> absences { get; set; }
    }
}