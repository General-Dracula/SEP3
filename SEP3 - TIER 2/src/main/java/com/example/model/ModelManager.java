package com.example.model;

import com.example.Data.Student;
import com.example.tier3Mediator.Tier3Connection;
import com.example.tier3Mediator.Tier3SocketConnection;
import com.example.tier3NetworkPackages.NetworkPackage;
import org.springframework.stereotype.Component;


@Component
public class ModelManager implements Model, Tier3Model, Tier1Model
{
    private Tier3Connection tier3Connection;

    public ModelManager()
    {
        tier3Connection = new Tier3SocketConnection((Tier3Model) this);
        tier3Connection.connect(6969, "localhost");
        tier3Connection.waitFromTier3();
    }


    public NetworkPackage checkLogInInfo(String id, String password)
    {
        return tier3Connection.checkLogInData(id, password);
    }


    @Override
    public void OpenStudentGrades(Student data)
    {
        ////
    }
}
