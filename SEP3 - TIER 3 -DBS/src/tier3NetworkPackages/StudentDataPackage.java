package tier3NetworkPackages;

import Data.Student;

public class StudentDataPackage extends NetworkPackage {
    private Student data;

    public StudentDataPackage(NetworkType type, Student data, long id)
    {
        super(type, id);
        this.data = data;
    }

    public Student getData()
    {
        return this.data;
    }
}