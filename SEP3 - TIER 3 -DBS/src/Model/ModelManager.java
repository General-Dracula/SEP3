package Model;

import Data.Absence;
import Data.Grade;
import Data.Student;
import Data.Teacher;
import Data.Class;
import Tier2Mediator.Tier2Connection;
import Tier2Mediator.Tier2SocketConnection;
import tier3NetworkPackages.TeacherDataPackage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class ModelManager implements Model, Tier2Model
{
    Tier2Connection tier2Connection;
    String dateField = "";

    ////TESTING
    ArrayList<Grade> grades = new ArrayList<Grade>();
    ArrayList<Grade> gradesB = new ArrayList<Grade>();
    ArrayList<Absence> absences =  new ArrayList<Absence>();
    Student student;
    Teacher teacher;
    Class aClass;
    Class bClass;
    ArrayList<Student> studentsA, studentsB;
    ArrayList<Class> classes;

    public ModelManager()
    {
        tier2Connection = new Tier2SocketConnection(this);
        tier2Connection.connect(6969);
        tier2Connection.waitFromTier2();

        SimpleDateFormat formatterDate = new SimpleDateFormat("MM/dd/yyyy");
        java.util.Date date = new Date();
        dateField = formatterDate.format(date);

        //testing
        grades.add(new Grade(7, "01/02/2020", "Math"));
        grades.add(new Grade(10, "01/02/2020", "Math"));
        grades.add(new Grade(9, "01/02/2020", "Math"));
        grades.add(new Grade(10, "01/02/2020", "Math"));
        grades.add(new Grade(8, "01/02/2020", "Romanian"));
        grades.add(new Grade(5, "01/02/2020", "Romanian"));
        grades.add(new Grade(7, "01/02/2020", "Chemistry"));
        grades.add(new Grade(5, "01/02/2020", "Chemistry"));
        grades.add(new Grade(10, "01/02/2020", "English"));
        grades.add(new Grade(10, "01/02/2020", "English"));
        grades.add(new Grade(2, "01/02/2020", "Chemistry"));
        grades.add(new Grade(10, "01/02/2020", "Computer Science"));
        grades.add(new Grade(9, "01/02/2020", "Computer Science"));
        grades.add(new Grade(10, "01/02/2020", "Computer Science"));
        gradesB.add(new Grade(10, "01/02/2020", "Computer Science"));
        gradesB.add(new Grade(9, "01/02/2020", "Computer Science"));
        gradesB.add(new Grade(10, "01/02/2020", "Computer Science"));

        absences.add(new Absence("01/02/2020", false, "Math"));
        absences.add(new Absence("01/02/2020", true, "Romanian"));
        absences.add(new Absence("01/02/2020", false, "Math"));
        absences.add(new Absence("01/02/2020", true, "Math"));
        absences.add(new Absence("01/02/2020", false, "Math"));
        absences.add(new Absence("01/02/2020", false, "Chemistry"));
        absences.add(new Absence("01/02/2020", false, "English"));
        absences.add(new Absence("01/02/2020", false, "Computer Science"));
        absences.add(new Absence("01/02/2020", true, "Computer Science"));
        absences.add(new Absence("01/02/2020", true, "Computer Science"));

        studentsA = new ArrayList<Student>();
        studentsB = new ArrayList<Student>();

        student = new Student("1", "Dodonica", "Puta mica", "Sugi pula dodon 13", "01/12/2000", "1", "07442121", grades, absences);
        studentsA.add(student);
        student = new Student("3", "Paul", "Balan", "Sugi pula dodon 13", "01/12/2000", "1", "07442121", grades, absences);
        studentsA.add(student);
        student = new Student("4", "Mircea", "Dobre", "Sugi pula dodon 13", "01/12/2000", "1", "07442121", grades, absences);
        studentsB.add(student);
        student = new Student("5", "Sandu", "Chilat", "Sugi pula dodon 13", "01/12/2000", "1", "07442121", gradesB, absences);
        studentsB.add(student);

        aClass = new Class(12, 'A', "112", studentsA);
        bClass = new Class(11, 'B', "112", studentsB);
        classes = new ArrayList<Class>();
        classes.add(aClass);
        classes.add(bClass);

        teacher = new Teacher("2", "Baba", "Cloanta", "2", classes);
    }

    private Teacher getTeacherData(String id)
    {
        System.out.println("----------TEACHER DATA " + teacher.getFirstName());
        return this.teacher;
    }

    private Student getStudentData(String id)
    {
        for(int i = 0; i < studentsA.size(); i++)
            if(studentsA.get(i).getId().equals(id))
                return studentsA.get(i);

        for(int i = 0; i < studentsB.size(); i++)
            if(studentsB.get(i).getId().equals(id))
                return studentsB.get(i);
        return null;
    }

    private String isUserValid(String id, String password)
    {
        if(id.equals("2") && password.equals("2"))
            return "Teacher";
        else
        {
            for(int i = 0; i < studentsA.size(); i++)
                if(studentsA.get(i).getId().equals(id) && studentsA.get(i).getViewGradePassword().equals(password))
                    return "Student";

            for(int i = 0; i < studentsB.size(); i++)
                if(studentsB.get(i).getId().equals(id) && studentsB.get(i).getViewGradePassword().equals(password))
                    return "Student";
        }
        return null;
    }

    @Override
    public void CheckLogInData(String id, String password, long id2)
    {
        ///FOR NOW
        String validUser = isUserValid(id, password);
        if(validUser == null)
        {
            tier2Connection.logInError("There was an error", id2);
            System.out.println("!!!!!!!!!!!!!!!!");
        }
        else if(validUser.equals("Student"))
            tier2Connection.openStudent(getStudentData(id), id2);
        else if(validUser.equals("Teacher"))
            tier2Connection.openTeacher(getTeacherData(id), id2);
    }

    @Override
    public void TeacherAssignGrade(String studentId, String course, String grade, String teacherID ,Long id)
    {
        System.out.println("!!!!!!!!!!!!!!!!!!ASSIGN GRADE");

            for(int i = 0; i < studentsA.size(); i++)
                if(studentsA.get(i).getId().equals(studentId))
                {
                    studentsA.get(i).getGrades().add(new Grade(Integer.valueOf(grade), dateField, course));
                    tier2Connection.openTeacher(getTeacherData(teacherID), id);
                }

            for(int i = 0; i < studentsB.size(); i++)
                if(studentsB.get(i).getId().equals(studentId))
                {
                    studentsB.get(i).getGrades().add(new Grade(Integer.valueOf(grade), dateField, course));
                    tier2Connection.openTeacher(getTeacherData(teacherID), id);
                }


        tier2Connection.teacherError("Something is wrong boyy", id);
    }
}
