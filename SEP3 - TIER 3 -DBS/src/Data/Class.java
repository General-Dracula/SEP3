package Data;

import java.util.ArrayList;

public class Class
{
    private int year;
    private char letter;

    private ArrayList<Student> students;

    public Class()
    {
        this.year = 0;
        this.students = null;
        this.letter = ' ';
    }

    public Class(int year, char letter, ArrayList<Student> students)
    {
        this.year = year;
        this.letter = letter;
        this.students = students;
    }



    public ArrayList<Student> getStudents()
    {
        return students;
    }

    public void setStudents(ArrayList<Student> students)
    {
        this.students = students;
    }
}
