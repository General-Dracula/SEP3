package Data;

public class Absence
{
    private String date;
    private boolean motivated;
    private String course;

    public Absence(String date, boolean motivated, String course)
    {
        this.date = date;
        this.motivated = motivated;
        this.course = course;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public boolean isMotivated()
    {
        return motivated;
    }

    public void setMotivated(boolean motivated)
    {
        this.motivated = motivated;
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
