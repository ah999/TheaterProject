package com.company;

import java.io.*;
import java.net.Socket;

public class ClientSocketTask implements Runnable {
    /**
     * Created by PR on 07.11.2017.
     */
    private Socket connection;  //Create Socket
    /**
     * define the transport address (network address IP + Port number)
     */
    private int port = 1234; // initialize port number
    private String ip = "localhost"; // localhost ip address = 127.0.0.1
    /**
     * String variable to store the client request
     */
    public TeamMember clientRequest = null;
    public String input = "";

    public ClientSocketTask(TeamMember _clientRequest) {
        clientRequest = _clientRequest;
    }

    @Override
    public void run() {
        try {
            /***
             *  Connect with server */
            connection = new Socket(ip, port); //Create a Client Socket for "localhost" address and port
            System.out.println("Connected! sending: ´" + clientRequest + "´ to server...\nINFO:" + connection);

            /***
             *  Setting up output stream */

            ObjectOutputStream wr = new ObjectOutputStream(connection.getOutputStream()); //Create a Request Object Buffer
            wr.writeObject(clientRequest); //write Request object in the outputStream
            wr.flush(); //Send written content to server

            /***
             *  Setting up input stream */

            ObjectInputStream rd = new ObjectInputStream(connection.getInputStream());//Create a Reply Object Buffer
            TeamMember member = (TeamMember) rd.readObject(); //Read Server Reply
            if(clientRequest.getState().equals("1")){
                System.out.println("Server replied: " + member.getName() + " is registered successfully "); //Print the Server reply

            }else if(clientRequest.getState().equals("2")){
                System.out.println("Server replied: The member name: " + member.getName() + " ....... the member rate: "+member.getRate()); //Print the Server reply
            }else{
                System.out.println("The member doesn't exist !!");
            }

            wr.close();
            rd.close();

            /***
             /* Close streams*/
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}