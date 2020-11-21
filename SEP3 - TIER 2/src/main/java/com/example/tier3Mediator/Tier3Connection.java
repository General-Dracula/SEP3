package com.example.tier3Mediator;

import com.example.tier3NetworkPackages.NetworkPackage;

public interface Tier3Connection
{
    public NetworkPackage checkLogInData(String id, String password);

    public NetworkPackage assignGrade(String studentId, String course, int grade, String teacherID);
    public NetworkPackage assignAbsence(String studentId, String course, String teacherID);


    public boolean isConnected();
    public void closeSocket();
    public void connect(int port, String host);
    public void waitFromTier3();

}
