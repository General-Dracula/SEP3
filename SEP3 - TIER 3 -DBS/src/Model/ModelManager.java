package Model;

import Data.Absence;
import Data.Grade;
import Data.Student;
import Tier2Mediator.Tier2Connection;
import Tier2Mediator.Tier2SocketConnection;

import java.util.ArrayList;


public class ModelManager implements Model, Tier2Model
{
    Tier2Connection tier2Connection;

    public ModelManager()
    {
        tier2Connection = new Tier2SocketConnection(this);
        tier2Connection.connect(6969);
        tier2Connection.waitFromTier2();
    }

    @Override
    public void CheckLogInData(String id, String password, long id2)
    {
        //checking in the dbs and sending the appropiate msg
        ArrayList<Grade> grades = new ArrayList<Grade>();
        ArrayList<Absence> absences =  new ArrayList<Absence>();

        grades.add(new Grade(5, "1/5/2020", "Math"));
        grades.add(new Grade(7, "1/6/2020", "Math"));
        grades.add(new Grade(8, "1/7/2020", "Romanian"));
        grades.add(new Grade(7, "1/8/2020", "Chemistry"));
        grades.add(new Grade(9, "1/9/2020", "Chemistry"));
        grades.add(new Grade(3, "1/10/2020", "Math"));

        absences.add(new Absence("1/10/2020", false, "Math"));
        absences.add(new Absence("2/10/2020", true, "Romanian"));
        absences.add(new Absence("3/10/2020", false, "Math"));
        absences.add(new Absence("4/10/2020", false, "Math"));

        Student student = new Student("1", "Dodon", "Muila", "Str. Sugerii, Nr. 69", "01/12/2000", "1", "07442121", grades, absences);

        System.out.println(id + " -------------------" + password);
        if(id.equals(student.getId()) && password.equals(student.getViewGradePassword()))
            tier2Connection.openStudentWindow(student, id2);
        else tier2Connection.logInError("There was an error", id2);
    }
}
