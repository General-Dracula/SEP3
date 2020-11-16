package com.example.tier3NetworkPackages;

import com.example.Data.Student;

public class StudentDataPackage extends NetworkPackage {
    private Student data;

    public StudentDataPackage(NetworkType type, Student data, long id)
    {
        super(type, id);
        this.data = data;
    }

    public StudentDataPackage()
    {
        super(NetworkType.StudentData, Long.valueOf(10));
    }

    public Student getData()
    {
        return this.data;
    }
}