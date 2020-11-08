package com.example.tier3Mediator;

import com.google.gson.Gson;
import com.example.model.Tier3Model;
import com.example.tier3NetworkPackages.NetworkPackage;
import com.example.tier3NetworkPackages.NetworkType;
import com.example.tier3NetworkPackages.StudentDataPackage;
import com.example.tier3NetworkPackages.TwoFieldPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class Tier3SocketConnection implements Tier3Connection
{
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    private Tier3Model model;
    private Gson gson;
    private boolean stopCondition;

    private long counter;
    private ArrayList<NetworkPackage> requestList;

    public Tier3SocketConnection(Tier3Model model)
    {
        this.model = model;
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
                    case StudentWindowData:
                        StudentDataPackage studentDataPackage = gson.fromJson(message, StudentDataPackage.class);
                        System.out.println("!!!!!!!!!!!!!!!!!!Student Window data  " + studentDataPackage.getData().getAddress());
                        requestList.add(studentDataPackage);
                        //model.OpenStudentGrades(studentDataPackage.getData());
                        break;
                case LogInError:
                        TwoFieldPackage logInError = gson.fromJson(message, TwoFieldPackage.class);
                        System.out.println("------------ERROR!!!!!!!!!!!!!!!!!!");
                        requestList.add(logInError);
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

    public NetworkPackage checkLogInData(String id, String password)
    {
        long aux = getCounter();
        NetworkPackage aux2 = null;
        writer.println(gson.toJson(new TwoFieldPackage(NetworkType.LogInRequest, id, password, aux)));
        //Runnable runnable = () -> {
            //NetworkPackage aux2;
            boolean bai = true;
            while(bai) {
                for (int i = 0; i <  requestList.size(); i++) {
                    if (requestList.get(i).getId() == aux)
                    {
                        aux2 = requestList.get(i);
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
            return aux2;
        //};
        //Thread t = new Thread(runnable);
       // t.setDaemon(true);
        //t.start();
        //System.out.println("-------------------------------" + aux2.get().getType().toString());
        //NetworkPackage bai2 = aux2.get();
        //return bai2;
    }


    public synchronized long getCounter()
    {
        counter++;
        return counter;
    }

}
