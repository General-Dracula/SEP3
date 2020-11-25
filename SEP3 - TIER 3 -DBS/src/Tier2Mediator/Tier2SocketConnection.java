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

//                case :
//
//                    break;
//                case :
//
//                    break;
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


}
