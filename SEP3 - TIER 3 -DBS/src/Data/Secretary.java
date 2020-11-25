package Data;

import java.util.ArrayList;

public class Secretary
{
    private String id;
    private String password;

    private ArrayList<Teacher> teachers;
    private ArrayList<Class> classes;

    public Secretary()
    {
       this.id = null;
       this.password = null;
       this.teachers = null;
       this.classes = null;
    }

    public Secretary(String id, String password, ArrayList<Teacher> teachers, ArrayList<Class> classes)
    {
        this.id = id;
        this.password = password;
        this.classes = classes;
        this.teachers = teachers;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public ArrayList<Teacher> getTeachers()
    {
        return teachers;
    }

    public void setTeachers(ArrayList<Teacher> teachers)
    {
        this.teachers = teachers;
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
