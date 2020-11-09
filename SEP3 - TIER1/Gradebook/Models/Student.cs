using System.Collections.Generic;

namespace WebApplication.Models
{
    public class Student
    {
        private string id;
        private string firstName;
        private string lastName;
        private string address;
        private string birthday;
        private string viewGradePassword;
        private string phoneNumber;
        private List<Grade> grades;
        private List<Absence> absences;

        public Student(string id, string firstName, string lastName, string address, string birthday, string viewGradePassword, string phoneNumber, List<Grade> grades, List<Absence> absences)
        {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.birthday = birthday;
            this.viewGradePassword = viewGradePassword;
            this.phoneNumber = phoneNumber;
            this.grades = grades;
            this.absences = absences;
        }
        
        public Student()
        {
            id = null;
            firstName = null;
            lastName = null;
            address = null;
            birthday = null;
            viewGradePassword = null;
            phoneNumber = null;
            grades = null;
            absences = null;
        }
        
        public string getId()
        {
            return id;
        }

        public void setId(string id)
        {
            this.id = id;
        }

        public string getFirstName()
        {
            return firstName;
        }

        public void setFirstName(string firstName)
        {
            this.firstName = firstName;
        }

        public string getLastName()
        {
            return lastName;
        }

        public void setLastName(string lastName)
        {
            this.lastName = lastName;
        }

        public string getAddress()
        {
            return address;
        }

        public void setAddress(string address)
        {
            this.address = address;
        }

        public string getBirthday()
        {
            return birthday;
        }

        public void setBirthday(string birthday)
        {
            this.birthday = birthday;
        }

        public string getViewGradePassword()
        {
            return viewGradePassword;
        }

        public void setViewGradePassword(string viewGradePassword)
        {
            this.viewGradePassword = viewGradePassword;
        }

        public string getPhoneNumber()
        {
            return phoneNumber;
        }

        public void setPhoneNumber(string phoneNumber)
        {
            this.phoneNumber = phoneNumber;
        }

        public List<Grade> getGrades()
        {
            return grades;
        }

        public void setGrades(List<Grade> grades)
        {
            this.grades = grades;
        }

        public List<Absence> getAbsences()
        {
            return absences;
        }

        public void setAbsences(List<Absence> absences)
        {
            this.absences = absences;
        }
    }
}