package Data;

public class Grade
{
    private int grade;
    private String date;
    private String course;

    public Grade(int grade, String date, String course)
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

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public String getCourse()
    {
        return course;
    }

    public void setCourse(String course)
    {
        this.course = course;
    }
}
