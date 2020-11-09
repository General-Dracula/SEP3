namespace WebApplication.Models
{
    public class Absence
    {
        private string date;
        private bool motivated;
        private string course;

        public Absence(string date, bool motivated, string course)
        {
            this.date = date;
            this.motivated = motivated;
            this.course = course;
        }

        public string getDate()
        {
            return date;
        }

        public void setDate(string date)
        {
            this.date = date;
        }

        public bool isMotivated()
        {
            return motivated;
        }

        public void setMotivated(bool motivated)
        {
            this.motivated = motivated;
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