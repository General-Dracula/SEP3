package com.example.tier3Mediator;

import com.example.Data.Student;
import com.example.tier3NetworkPackages.*;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class Tier3SocketConnection implements Tier3Connection
{
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    private Gson gson;
    private boolean stopCondition;

    private long counter;
    private ArrayList<NetworkPackage> requestList;

    public Tier3SocketConnection()
    {
        gson = new Gson();
        stopCondition = false;
        counter = 0;
        requestList = new ArrayList<NetworkPackage>();
    }


    public void connect(int port, String host)
    {
        try {
            socket = new Socket(host, port);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public boolean isConnected()
    {
        return this.socket.isConnected();
    }

    public void closeSocket()
    {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void waitFromTier3()
    {
        Runnable runnable = () -> {
            String message = null;
            NetworkPackage dataPackage;
            while (!stopCondition) {
                try {
                    message = reader.readLine();
                } catch (IOException e) {
                    System.out.println(socket.getRemoteSocketAddress().toString() + " - disconnected");
                    stopCondition = true;
                    e.printStackTrace();
                }

                dataPackage = gson.fromJson(message, NetworkPackage.class);

                switch (dataPackage.getType()) {
                    case StudentData:
                        StudentDataPackage studentDataPackage = gson.fromJson(message, StudentDataPackage.class);
                        requestList.add(studentDataPackage);
                        break;
                case LogInError:
                        TwoFieldPackage logInError = gson.fromJson(message, TwoFieldPackage.class);
                        System.out.println("------------ERROR!!!!!!!!!!!!!!!!!!");
                        requestList.add(logInError);
                    break;

                    case TeacherData:
                        TeacherDataPackage teacherDataPackage = gson.fromJson(message, TeacherDataPackage.class);
                        System.out.println(" -------------------" + teacherDataPackage.getData().getFirstName());
                        requestList.add(teacherDataPackage);
                    break;

                    case TeacherError:
                        TwoFieldPackage twoFieldPackage2 = gson.fromJson(message, TwoFieldPackage.class);
                        requestList.add(twoFieldPackage2);
                        break;


                    case SecretaryData:
                        SecretaryDataPackage secretaryDataPackage = gson.fromJson(message, SecretaryDataPackage.class);
                        System.out.println(" -------------------" + secretaryDataPackage.getData().getId());
                        requestList.add(secretaryDataPackage);
                    break;

                    case SecretaryError:
                        TwoFieldPackage twoFieldPackage = gson.fromJson(message, TwoFieldPackage.class);
                        System.out.println(" -------------------" + twoFieldPackage.getFirstField());
                        requestList.add(twoFieldPackage);
                        break;
//                case :
//
//                    break;
                }


            }  //while end

        };
        Thread t = new Thread(runnable);
        //t.setDaemon(true);
        t.start();
    }

    public NetworkPackage waitForResponse(Long id)
    {
        NetworkPackage responsePackage = null;
        boolean bai = true;
        while(bai) {
            for (int i = 0; i <  requestList.size(); i++) {
                if (requestList.get(i).getId() == id)
                {
                    responsePackage = requestList.get(i);
                    requestList.remove(i);
                    bai = false;
                }
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return responsePackage;
    }

    @Override
    public NetworkPackage createTeacher(String firstName, String lastName, String password)
    {
        long currentCounter = getCounter();
        writer.println(gson.toJson(new ThreeFieldPackage(NetworkType.SecretaruCreateTeacher, firstName, lastName, password, currentCounter)));
        return this.waitForResponse(currentCounter);
    }

    @Override
    public NetworkPackage editTeacher(String id, String password)
    {
        long currentCounter = getCounter();
        writer.println(gson.toJson(new TwoFieldPackage(NetworkType.SecretaryEditTeacher, id, password, currentCounter)));
        return this.waitForResponse(currentCounter);
    }

    @Override
    public NetworkPackage deleteTeacher(String id)
    {
        long currentCounter = getCounter();
        writer.println(gson.toJson(new TwoFieldPackage(NetworkType.SecretaryDeleteTeacher, id, "", currentCounter)));
        return this.waitForResponse(currentCounter);
    }

    @Override
    public NetworkPackage createStudent(String firstName, String lastName, String address, String password, String phoneNr, String birthday)
    {
        long currentCounter = getCounter();
        writer.println(gson.toJson(new StudentDataPackage(NetworkType.SecretaryCreateStudent, new Student("0", firstName, lastName, address, birthday, password, phoneNr, null, null), currentCounter)));
        return this.waitForResponse(currentCounter);
    }

    @Override
    public NetworkPackage deleteStudent(String id)
    {
        long currentCounter = getCounter();
        writer.println(gson.toJson(new TwoFieldPackage(NetworkType.SecretaryDeleteStudent, id, "", currentCounter)));
        return this.waitForResponse(currentCounter);
    }

    @Override
    public NetworkPackage editStudent(String studentId, String address, String password, String phoneNr)
    {
        long currentCounter = getCounter();
        writer.println(gson.toJson(new FourFieldPackage(NetworkType.SecretaryEditStudent, studentId, address, password, phoneNr, currentCounter)));
        return this.waitForResponse(currentCounter);
    }

    @Override
    public NetworkPackage createClass(String classNr, String classLetter, String teacherId)
    {
        long currentCounter = getCounter();
        writer.println(gson.toJson(new ThreeFieldPackage(NetworkType.SecretaryCreateClass, classNr, classLetter, teacherId, currentCounter)));
        return this.waitForResponse(currentCounter);
    }

    @Override
    public NetworkPackage deleteClass(String classLetter, String classNr)
    {
        long currentCounter = getCounter();
        writer.println(gson.toJson(new TwoFieldPackage(NetworkType.SecretaryDeleteClass, classNr, classLetter, currentCounter)));
        return this.waitForResponse(currentCounter);
    }

    @Override
    public NetworkPackage classAddStudent(String classNr, String classLetter, String studentId)
    {
        long currentCounter = getCounter();
        writer.println(gson.toJson(new ThreeFieldPackage(NetworkType.SecretaryClassAddStudent, classNr, classLetter, studentId, currentCounter)));
        return this.waitForResponse(currentCounter);
    }

    @Override
    public NetworkPackage classRemoveStudent(String classNr, String classLetter, String studentId)
    {
        long currentCounter = getCounter();
        writer.println(gson.toJson(new ThreeFieldPackage(NetworkType.SecretaryClassRemoveStudent, classNr, classLetter, studentId, currentCounter)));
        return this.waitForResponse(currentCounter);
    }

    @Override
    public NetworkPackage classAddCourse(String classNr, String classLetter, String courseName)
    {
        long currentCounter = getCounter();
        writer.println(gson.toJson(new ThreeFieldPackage(NetworkType.SecretaryClassAddCourse, classNr, classLetter, courseName, currentCounter)));
        return this.waitForResponse(currentCounter);
    }

    @Override
    public NetworkPackage classRemoveCourse(String classNr, String classLetter, String courseName)
    {
        long currentCounter = getCounter();
        writer.println(gson.toJson(new ThreeFieldPackage(NetworkType.SecretaryClassRemoveCourse, classNr, classLetter, courseName, currentCounter)));
        return this.waitForResponse(currentCounter);
    }

    @Override
    public NetworkPackage changeSecretaryUsername(String newUsername)
    {
        long currentCounter = getCounter();
        writer.println(gson.toJson(new TwoFieldPackage(NetworkType.SecretaryChangeUsername, newUsername, "", currentCounter)));

        return this.waitForResponse(currentCounter);
    }

    @Override
    public NetworkPackage changeSecretaryPassword(String newPassword)
    {
        long currentCounter = getCounter();
        writer.println(gson.toJson(new TwoFieldPackage(NetworkType.SecretaryChangePassword, newPassword, "", currentCounter)));
        return this.waitForResponse(currentCounter);
    }

    public NetworkPackage checkLogInData(String id, String password)
    {
        long currentCounter = getCounter();
        writer.println(gson.toJson(new TwoFieldPackage(NetworkType.LogInRequest, id, password, currentCounter)));

        return this.waitForResponse(currentCounter);
    }

    @Override
    public NetworkPackage assignGrade(String studentId, String course, int grade, String teacherID)
    {
        long currentCounter = getCounter();
        writer.println(gson.toJson(new FourFieldPackage(NetworkType.TeacherAssignGrade, studentId, course, String.valueOf(grade), teacherID, currentCounter)));
        return this.waitForResponse(currentCounter);
    }

    @Override
    public NetworkPackage assignAbsence(String studentId, String course, String teacherID)
    {
        long currentCounter = getCounter();
        writer.println(gson.toJson(new ThreeFieldPackage(NetworkType.TeacherAssignAbsence, studentId, course, teacherID, currentCounter)));
        return this.waitForResponse(currentCounter);
    }

    @Override
    public NetworkPackage motivateAbsence(String studentID, String course, String date, String teacherID)
    {
        long currentCounter = getCounter();
        writer.println(gson.toJson(new FourFieldPackage(NetworkType.TeacherMotivateAbsence, studentID, course, date, teacherID, currentCounter)));
        return this.waitForResponse(currentCounter);
    }


    public synchronized long getCounter()
    {
        if(counter > 100000000)
            counter = 0;
        counter++;
        return counter;
    }

}
