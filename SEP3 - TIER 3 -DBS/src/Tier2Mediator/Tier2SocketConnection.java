package Tier2Mediator;

import Data.Secretary;
import Data.Student;
import Data.Teacher;
import Model.Tier2Model;
import com.google.gson.Gson;
import tier3NetworkPackages.*;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Tier2SocketConnection implements Tier2Connection
{
    private Socket socket;
    ServerSocket welcomeSocket;
    private BufferedReader reader;
    private PrintWriter writer;
    private Tier2Model model;
    private Gson gson;
    private boolean stopCondition;

    public Tier2SocketConnection(Tier2Model model)
    {
        this.model = model;
        gson = new Gson();
        stopCondition = false;
    }


    public void connect(int port)
    {
        try {
            welcomeSocket = new ServerSocket(port);
            socket = welcomeSocket.accept();
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


    public void waitFromTier2()
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
                    case LogInRequest:
                        TwoFieldPackage twoFieldPackage = gson.fromJson(message, TwoFieldPackage.class);
                        System.out.println("Log In Request" + twoFieldPackage.getFirstField());
                        model.CheckLogInData(twoFieldPackage.getFirstField(), twoFieldPackage.getSecondField(), twoFieldPackage.getId());
                        break;

                    case TeacherAssignGrade:
                        FourFieldPackage threeFieldPackage = gson.fromJson(message, FourFieldPackage.class);
                        model.TeacherAssignGrade(threeFieldPackage.getFirstField(), threeFieldPackage.getSecondField(), threeFieldPackage.getThirdField(), threeFieldPackage.getFourthField(), threeFieldPackage.getId());
                        break;

                    case TeacherAssignAbsence:
                        FourFieldPackage threeFieldPackage2 = gson.fromJson(message, FourFieldPackage.class);
                        model.TeacherAssignAbsence(threeFieldPackage2.getFirstField(), threeFieldPackage2.getSecondField(), threeFieldPackage2.getThirdField(), threeFieldPackage2.getId());
                        break;

                    case TeacherMotivateAbsence:
                        FourFieldPackage fourFieldPackage = gson.fromJson(message, FourFieldPackage.class);
                        System.out.println("-MOTIVATE ABSENCE");
                        model.TeacherMotivateAbsence(fourFieldPackage.getFirstField(), fourFieldPackage.getSecondField(), fourFieldPackage.getThirdField(), fourFieldPackage.getFourthField(), fourFieldPackage.getId());
                        break;

                    case SecretaruCreateTeacher:
                        ThreeFieldPackage threeFieldPackage1 = gson.fromJson(message, ThreeFieldPackage.class);
                        System.out.println("-CREATE TEACHER");
                        model.SecretaryCreateTeacher(threeFieldPackage1.getFirstField(), threeFieldPackage1.getSecondField(), threeFieldPackage1.getThirdField(), threeFieldPackage1.getId());
                        break;

                    case SecretaryEditTeacher:
                        TwoFieldPackage twoFieldPackage1 = gson.fromJson(message, TwoFieldPackage.class);
                        System.out.println("Secretary edit teacher" + twoFieldPackage1.getFirstField());
                        model.SecretaryEditTeacher(twoFieldPackage1.getFirstField(), twoFieldPackage1.getSecondField(), twoFieldPackage1.getId());
                        break;

                    case SecretaryDeleteTeacher:
                        TwoFieldPackage twoFieldPackage2 = gson.fromJson(message, TwoFieldPackage.class);
                        System.out.println("Secretary delete teacher" + twoFieldPackage2.getFirstField());
                        model.SecretaryDeleteTeacher(twoFieldPackage2.getFirstField(), twoFieldPackage2.getId());
                        break;

                    case SecretaryCreateStudent:
                        StudentDataPackage studentDataPackage = gson.fromJson(message, StudentDataPackage.class);
                        System.out.println("Student create student" + studentDataPackage.getData().getId());
                        model.SecretaryCreateStudent(studentDataPackage.getData(), studentDataPackage.getId());
                        break;

                    case SecretaryDeleteStudent:
                        TwoFieldPackage twoFieldPackage3 = gson.fromJson(message, TwoFieldPackage.class);
                        System.out.println("Secretary delete student" + twoFieldPackage3.getFirstField());
                        model.SecretaryDeleteStudent(twoFieldPackage3.getFirstField(), twoFieldPackage3.getId());
                        break;

                    case SecretaryEditStudent:
                        FourFieldPackage fourFieldPackage1 = gson.fromJson(message, FourFieldPackage.class);
                        System.out.println("Secretary delete student" + fourFieldPackage1.getFirstField());
                        model.SecretaryEditStudent(fourFieldPackage1.getFirstField(), fourFieldPackage1.getSecondField(), fourFieldPackage1.getThirdField(), fourFieldPackage1.getFourthField(), fourFieldPackage1.getId());
                        break;

                    case SecretaryCreateClass:
                        ThreeFieldPackage threeFieldPackage3 =  gson.fromJson(message, ThreeFieldPackage.class);
                        System.out.println("Secretary create class" + threeFieldPackage3.getFirstField());
                        model.SecretaryCreateClass(threeFieldPackage3.getFirstField(), threeFieldPackage3.getSecondField(), threeFieldPackage3.getThirdField(), threeFieldPackage3.getId());
                        break;

                    case SecretaryDeleteClass:
                        TwoFieldPackage twoFieldPackage4 = gson.fromJson(message, TwoFieldPackage.class);
                        System.out.println("Secretary delete class" + twoFieldPackage4.getFirstField());
                        model.SecretaryDeleteClass(twoFieldPackage4.getFirstField(), twoFieldPackage4.getSecondField(), twoFieldPackage4.getId());
                        break;

                    case SecretaryClassAddStudent:
                        ThreeFieldPackage threeFieldPackage4 = gson.fromJson(message, ThreeFieldPackage.class);
                        System.out.println("SECRETARY CLASS ADD STUDENT " + threeFieldPackage4.getFirstField());
                        model.SecretaryCLassAddStudent(threeFieldPackage4.getFirstField(), threeFieldPackage4.getSecondField(), threeFieldPackage4.getThirdField(), threeFieldPackage4.getId());
                        break;

                    case SecretaryClassRemoveStudent:
                        ThreeFieldPackage threeFieldPackage5 = gson.fromJson(message, ThreeFieldPackage.class);
                        System.out.println("SECRETARY CLASS REMOVE STUDENT " + threeFieldPackage5.getFirstField());
                        model.SecretaryClassRemoveStudent(threeFieldPackage5.getFirstField(), threeFieldPackage5.getSecondField(), threeFieldPackage5.getThirdField(), threeFieldPackage5.getId());
                        break;

                    case SecretaryClassAddCourse:
                        ThreeFieldPackage threeFieldPackage6 = gson.fromJson(message, ThreeFieldPackage.class);
                        System.out.println("SECRETARY CLASS ADD COURSE " + threeFieldPackage6.getFirstField());
                        model.SecretaryClassAddCourse(threeFieldPackage6.getFirstField(), threeFieldPackage6.getSecondField(), threeFieldPackage6.getThirdField(), threeFieldPackage6.getId());
                        break;

                    case SecretaryClassRemoveCourse:
                        ThreeFieldPackage threeFieldPackage7 = gson.fromJson(message, ThreeFieldPackage.class);
                        System.out.println("SECRETARY CLASS REMOVE COURSE " + threeFieldPackage7.getFirstField());
                        model.SecretaryClassRemoveCourse(threeFieldPackage7.getFirstField(), threeFieldPackage7.getSecondField(), threeFieldPackage7.getThirdField(), threeFieldPackage7.getId());
                        break;

                    case SecretaryChangeUsername:
                        TwoFieldPackage twoFieldPackage5 = gson.fromJson(message, TwoFieldPackage.class);
                        System.out.println("Secretary change userName" + twoFieldPackage5.getFirstField());
                        model.SecretaryChangeOwnUsername(twoFieldPackage5.getFirstField(), twoFieldPackage5.getId());
                        break;

                    case SecretaryChangePassword:
                        TwoFieldPackage twoFieldPackage6 = gson.fromJson(message, TwoFieldPackage.class);
                        System.out.println("Secretary changePassword" + twoFieldPackage6.getFirstField());
                        model.SecretaryChangeOwnPassword(twoFieldPackage6.getFirstField(), twoFieldPackage6.getId());
                        break;

                }


            }  //while end

        };
        Thread t = new Thread(runnable);
        //t.setDaemon(true);
        t.start();
    }

    @Override
    public void openStudent(Student data, long id)
    {
        writer.println(gson.toJson(new StudentDataPackage(NetworkType.StudentData, data, id)));
    }

    @Override
    public void logInError(String error, Long id)
    {
        writer.println(gson.toJson(new TwoFieldPackage(NetworkType.LogInError, error, "", id)));
    }

    @Override
    public void openTeacher(Teacher data, Long id)
    {
        writer.println(gson.toJson(new TeacherDataPackage(data, NetworkType.TeacherData, id)));
    }

    @Override
    public void teacherError(String error, Long id)
    {
        writer.println(gson.toJson(new TwoFieldPackage(NetworkType.TeacherError, error, "", id)));
    }

    @Override
    public void openSecretary(Secretary secretaryData, long id)
    {
        writer.println(gson.toJson(new SecretaryDataPackage(NetworkType.SecretaryData, secretaryData, id)));
    }

    @Override
    public void secretaryError(String error, Long id2)
    {
        writer.println(gson.toJson(new TwoFieldPackage(NetworkType.SecretaryError, error, "" , id2)));
    }


}
