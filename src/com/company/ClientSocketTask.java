package com.company;

import java.io.*;
import java.net.Socket;

public class ClientSocketTask implements Runnable {

    private Socket connection;  //Create Socket

    private int port = 1234; // initialize port number
    private String ip = "localhost"; // localhost ip address = 127.0.0.1

    public TeamMember clientRequest = null;
    public String input = "";

    public ClientSocketTask(TeamMember _clientRequest) {
        clientRequest = _clientRequest;
    }

    @Override
    public void run() {
        try {

            connection = new Socket(ip, port); //Create a Client Socket for "localhost" address and port
            System.out.println("Connected! sending: ´" + clientRequest + "´ to server...\nINFO:" + connection);



            ObjectOutputStream wr = new ObjectOutputStream(connection.getOutputStream()); //Create a Request Object Buffer
            wr.writeObject(clientRequest); //write Request object in the outputStream
            wr.flush(); //Send written content to server


            ObjectInputStream rd = new ObjectInputStream(connection.getInputStream());//Create a Reply Object Buffer
            TeamMember member = (TeamMember) rd.readObject(); //Read Server Reply
            if(clientRequest.getState().equals("1")){
                System.out.println("Server replied: " + member.getName() + " is registered successfully "); //Print the Server reply

            }else if(clientRequest.getState().equals("2")){
                System.out.println("Server replied: The member name: " + member.getName() + "\n The member rate: "+member.getRate()+"\n The Script: "+member.getScript()); //Print the Server reply
            }else{
                System.out.println("The member doesn't exist !!");
            }

            wr.close();
            rd.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}