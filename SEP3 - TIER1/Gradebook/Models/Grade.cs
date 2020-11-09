namespace WebApplication.Models
{
    public class Grade
    {
        private int grade;
        private string date;
        private string course;

        public Grade(int grade, string date, string course)
        {
            this.grade = grade;
            this.date = date;
            this.course = course;
        }

        public int getGrade()
        {
            return grade;
        }

        public void setGrade(int grade)
        {
            if(grade > 0 && grade < 11)
                this.grade = grade;
        }

        public string getDate()
        {
            return date;
        }

        public void setDate(string date)
        {
            this.date = date;
        }

        public string getCourse()
        {
            return course;
        }

        public void setCourse(string course)
        {
            this.course = course;
        }
    }
}