package com.example.model;

import com.example.tier1Mediator.Tier1ApiConnection;
import com.example.tier3NetworkPackages.NetworkPackage;
import org.springframework.stereotype.Component;

@Component
public interface Tier1Model
{
    public NetworkPackage checkLogInInfo(String id, String password);

    public NetworkPackage assignGrade(String studentId, String course, int grade, String teacherID);

    public NetworkPackage assignAbsence(String studentID, String course, String teacherID);
}
