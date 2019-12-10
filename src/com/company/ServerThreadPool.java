package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerThreadPool {
    /**
     * * Created by PR on 07.11.2017.*/
    private static Socket connection; //Create Socket
    private static ServerSocket serverSocket; //Create a Server Socket
    static ArrayList R = new ArrayList();
    private static ExecutorService thPoolServer = Executors.newFixedThreadPool(15); //Create a pool of threads
    public static void main(String[] args) throws IOException {
        serverSocket = new ServerSocket(1234); //Start a new server socket on port 1234
        while (true) {
            connection = serverSocket.accept();//Accept when a request arrives
            ServerSocketTask serverTask = new ServerSocketTask(connection);//Start a task Thread to handle client request
            thPoolServer.execute(serverTask);//Execute Thread

        }

    }

}
