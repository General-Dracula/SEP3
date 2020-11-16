package com.example.tier3NetworkPackages;

import com.example.Data.Teacher;

public class TeacherDataPackage extends NetworkPackage
{
    private Teacher data;
    public TeacherDataPackage(Teacher data, NetworkType type, Long id)
    {
        super(type, id);
        this.data = data;
    }

    public Teacher getData()
    {
        return data;
    }

    public void setData(Teacher data)
    {
        this.data = data;
    }
}
