package com.example.Data;

import java.util.ArrayList;

public class Teacher
{
    private String id;
    private String firstName;
    private String lastName;
    private String password;

    private ArrayList<Class> classes;

    public Teacher()
    {
        id = null;
        firstName = null;
        lastName = null;
        password = null;
        classes = null;
    }

    public Teacher(String id, String firstName, String lastName, String password, ArrayList<Class> classes)
    {
        this.classes = classes;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
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

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public ArrayList<Class> getClasses()
    {
        return classes;
    }

    public void setClasses(ArrayList<Class> classes)
    {
        this.classes = classes;
    }
}
