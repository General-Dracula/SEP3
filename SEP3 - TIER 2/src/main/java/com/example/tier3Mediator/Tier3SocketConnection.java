package com.example.tier3Mediator;

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
                        requestList.add(teacherDataPackage);
                    break;

                    case TeacherError:
                        TwoFieldPackage twoFieldPackage2 = gson.fromJson(message, TwoFieldPackage.class);
                        requestList.add(twoFieldPackage2);
                        break;


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

    public NetworkPackage checkLogInData(String id, String password)
    {
        long currentCounter = getCounter();
        NetworkPackage responsePackage = null;
        writer.println(gson.toJson(new TwoFieldPackage(NetworkType.LogInRequest, id, password, currentCounter)));
            boolean bai = true;
            while(bai) {
                for (int i = 0; i <  requestList.size(); i++) {
                    if (requestList.get(i).getId() == currentCounter)
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
    public NetworkPackage assignGrade(String studentId, String course, int grade, String teacherID)
    {
        long currentCounter = getCounter();
        NetworkPackage responsePackage = null;
        writer.println(gson.toJson(new FourFieldPackage(NetworkType.TeacherAssignGrade, studentId, course, String.valueOf(grade), teacherID, currentCounter)));
        boolean bai = true;
        while(bai) {
            for (int i = 0; i <  requestList.size(); i++) {
                if (requestList.get(i).getId() == currentCounter)
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


    public synchronized long getCounter()
    {
        if(counter > 100000000)
            counter = 0;
        counter++;
        return counter;
    }

}
