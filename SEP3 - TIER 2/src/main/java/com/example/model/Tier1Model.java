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

    public NetworkPackage motivateAbsence(String studentID, String course, String date, String teacherID);

    public NetworkPackage createTeacher(String firstName, String lastName, String password);

    public NetworkPackage editTeacher(String id, String password);

    public NetworkPackage deleteTeacher(String id);

    public NetworkPackage createStudent(String firstName, String lastName, String address, String password, String phoneNr, String birthday);

    public NetworkPackage deleteStudent(String id);

    public NetworkPackage editStudent(String studentId, String address, String password, String phoneNr);

    public NetworkPackage createClass(String classNr, String classLetter, String teacherId);

    public NetworkPackage deleteClass(String classLetter, String classNr);

    public NetworkPackage classAddStudent(String classNr, String classLetter, String studentId);

    public NetworkPackage classRemoveStudent(String classNr, String classLetter, String studentId);

    public NetworkPackage classAddCourse(String classNr, String classLetter, String courseName);

    public NetworkPackage classRemoveCourse(String classNr, String classLetter, String courseName);

    public NetworkPackage changeSecretaryUsername(String newUsername);

    public NetworkPackage changeSecretaryPassword(String newPassword);
}
