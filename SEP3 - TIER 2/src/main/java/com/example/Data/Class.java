package com.example.Data;

import java.util.ArrayList;

public class Class
{
    private int year;
    private char letter;
    private String teacherID;

    private ArrayList<Student> students;

    public Class()
    {
        this.year = 0;
        this.students = null;
        this.letter = ' ';
        this.teacherID = " ";
    }

    public Class(int year, char letter, String teacherID, ArrayList<Student> students)
    {
        this.year = year;
        this.letter = letter;
        this.students = students;
        this.teacherID = teacherID;
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
}
