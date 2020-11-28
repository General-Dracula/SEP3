package com.example.model;

import com.example.tier3Mediator.Tier3Connection;
import com.example.tier3Mediator.Tier3SocketConnection;
import com.example.tier3NetworkPackages.NetworkPackage;
import com.example.tier3NetworkPackages.NetworkType;
import com.example.tier3NetworkPackages.TwoFieldPackage;
import org.springframework.stereotype.Component;


@Component
public class ModelManager implements Model, Tier1Model
{
    private Tier3Connection tier3Connection;

    public ModelManager()
    {
        tier3Connection = new Tier3SocketConnection();
        tier3Connection.connect(6969, "localhost");
        tier3Connection.waitFromTier3();
    }


    public NetworkPackage checkLogInInfo(String id, String password)
    {
        return tier3Connection.checkLogInData(id, password);
    }

    @Override
    public NetworkPackage assignGrade(String studentId, String course, int grade, String teacherID)
    {
        return tier3Connection.assignGrade(studentId, course, grade, teacherID);
    }

    @Override
    public NetworkPackage assignAbsence(String studentID, String course, String teacherID)
    {
        return tier3Connection.assignAbsence(studentID, course, teacherID);
    }

    @Override
    public NetworkPackage motivateAbsence(String studentID, String course, String date, String teacherID)
    {
        return tier3Connection.motivateAbsence(studentID, course, date, teacherID);
    }

    @Override
    public NetworkPackage createTeacher(String firstName, String lastName, String password)
    {
        if(password.length() < 8)
            return new TwoFieldPackage(NetworkType.SecretaryError, "Password too short", "", 1);
        return tier3Connection.createTeacher(firstName, lastName, password);
    }

    @Override
    public NetworkPackage editTeacher(String id, String password)
    {
        if(password.length() < 8)
            return new TwoFieldPackage(NetworkType.SecretaryError, "Password too short", "", 1);
        return tier3Connection.editTeacher(id, password);
    }

    @Override
    public NetworkPackage deleteTeacher(String id)
    {
        return tier3Connection.deleteTeacher(id);
    }

    @Override
    public NetworkPackage createStudent(String firstName, String lastName, String address, String password, String phoneNr, String birthday)
    {
        return tier3Connection.createStudent(firstName, lastName, address, password, phoneNr, birthday);
    }

    @Override
    public NetworkPackage deleteStudent(String id)
    {
        return tier3Connection.deleteStudent(id);
    }

    @Override
    public NetworkPackage editStudent(String studentId, String address, String password, String phoneNr)
    {
        return tier3Connection.editStudent(studentId, address, password, phoneNr);
    }

    @Override
    public NetworkPackage createClass(String classNr, String classLetter, String teacherId)
    {
        return tier3Connection.createClass(classNr, classLetter, teacherId);
    }


}
