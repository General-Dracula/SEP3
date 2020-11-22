package Data;

import java.util.ArrayList;

public class Class
{
    private int year;
    private char letter;
    private String teacherID;

    private ArrayList<Student> students;
    private ArrayList<Course> courses;

    public Class()
    {
        this.year = 0;
        this.students = null;
        this.letter = ' ';
        this.teacherID = " ";
        this.courses = null;
    }

    public Class(int year, char letter, String teacherID, ArrayList<Student> students, ArrayList<Course> courses)
    {
        this.year = year;
        this.letter = letter;
        this.students = students;
        this.teacherID = teacherID;
        this.courses = courses;
    }



    public ArrayList<Student> getStudents()
    {
        return students;
    }

    public void setStudents(ArrayList<Student> students)
    {
        this.students = students;
    }

    public String getTeacherID()
    {
        return teacherID;
    }

    public void setTeacherID(String teacherID)
    {
        this.teacherID = teacherID;
    }

    public ArrayList<Course> getCourses()
    {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses)
    {
        this.courses = courses;
    }

    public char getLetter()
    {
        return letter;
    }

    public void setLetter(char letter)
    {
        this.letter = letter;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }
}
