package com.example.Data;

import java.util.ArrayList;

public class Student
{
    private String id;
    private String firstName;
    private String lastName;
    private String address;
    private String birthday;
    private String viewGradePassword;
    private String phoneNumber;

    private ArrayList<Grade> grades;
    private ArrayList<Absence> absences;

    public Student()
    {
        this.id = null;
        this.firstName = null;
        this.lastName = null;
        this.address = null;
        this.birthday = null;
        this.viewGradePassword = null;
        this.phoneNumber = null;

        this.grades = null;
        this.absences = null;
    }

    public Student(String id, String firstName, String lastName, String address, String birthday, String viewGradePassword, String phoneNumber, ArrayList<Grade> grades, ArrayList<Absence> absences)
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

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getBirthday()
    {
        return birthday;
    }

    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }

    public String getViewGradePassword()
    {
        return viewGradePassword;
    }

    public void setViewGradePassword(String viewGradePassword)
    {
        this.viewGradePassword = viewGradePassword;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<Grade> getGrades()
    {
        return grades;
    }

    public void setGrades(ArrayList<Grade> grades)
    {
        this.grades = grades;
    }

    public ArrayList<Absence> getAbsences()
    {
        return absences;
    }

    public void setAbsences(ArrayList<Absence> absences)
    {
        this.absences = absences;
    }
}
