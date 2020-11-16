package Model;

import Data.Absence;
import Data.Grade;
import Data.Student;
import Data.Teacher;
import Data.Class;
import Tier2Mediator.Tier2Connection;
import Tier2Mediator.Tier2SocketConnection;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class ModelManager implements Model, Tier2Model
{
    Tier2Connection tier2Connection;
    String dateField = "";

    ////TESTING
    ArrayList<Grade> grades = new ArrayList<Grade>();
    ArrayList<Absence> absences =  new ArrayList<Absence>();
    Student student;
    Teacher teacher;
    Class aClass;
    ArrayList<Student> students;
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

        student = new Student("1", "Dodonica", "Puta mica", "Sugi pula dodon 13", "01/12/2000", "1", "07442121", grades, absences);

        students = new ArrayList<Student>();
        students.add(student);

        aClass = new Class(12, 'A', "112", students);

        classes = new ArrayList<Class>();
        classes.add(aClass);

        teacher = new Teacher("112", "Baba", "Cloanta", "Sug", classes);
    }

    @Override
    public void CheckLogInData(String id, String password, long id2)
    {
        ///FOR NOW
        if(id.equals(student.getId()) && password.equals(student.getViewGradePassword()))
            tier2Connection.openStudent(student, id2);
        else if(id.equals(teacher.getId()) && password.equals(teacher.getPassword()))
            tier2Connection.openTeacher(teacher, id2);
        else
        {
            tier2Connection.logInError("There was an error", id2);
            System.out.println("!!!!!!!!!!!!!!!!");
        }
    }

    @Override
    public void TeacherAssignGrade(String studentId, String course, String grade, Long id)
    {
        if(student.getId().equals(studentId))
        {
            student.getGrades().add(new Grade(Integer.valueOf(grade), dateField, course));
            tier2Connection.openTeacher(teacher, id);
        }
        else tier2Connection.teacherError("Something is wrong boyy", id);
    }
}
