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

        grades.add(new Grade(7, "6/9/6969", "Math"));
        grades.add(new Grade(10, "6/9/6969", "Math"));
        grades.add(new Grade(8, "6/9/6969", "Romanian"));
        grades.add(new Grade(7, "6/9/6969", "Chemistry"));

        absences.add(new Absence("12/2/2999", false, "Math"));
        absences.add(new Absence("11/2/2999", true, "Romanian"));
        absences.add(new Absence("12/2/2999", false, "Math"));
        absences.add(new Absence("12/2/2999", false, "Math"));

        Student student = new Student("62-10", "Dodonica", "Puta mica", "Sugi pula dodon 13", "01/12/2000", "Sugpula69", "07442121", grades, absences);

        System.out.println(id + " -------------------" + password);
        if(id.equals(student.getId()) && password.equals(student.getViewGradePassword()))
            tier2Connection.openStudentWindow(student, id2);
        else tier2Connection.logInError("There was an error", id2);
    }
}
