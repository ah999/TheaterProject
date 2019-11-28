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

    public ClientSocketTask(TeamMember _clientRequest, String _input) {
        clientRequest = _clientRequest;
        input = _input;
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

            BufferedWriter br = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream())); //Create a Request Buffer
            br.write(input + "\n"); //write "Request" in the outputStream
            br.flush();
            ObjectOutputStream wr = new ObjectOutputStream(connection.getOutputStream()); //Create a Request Object Buffer
            wr.writeObject(clientRequest); //write Request object in the outputStream
            wr.flush(); //Send written content to server
            System.out.println("fkf");
            /***
             *  Setting up input stream */

            BufferedReader b = new BufferedReader(new InputStreamReader(connection.getInputStream())); //Create a Request Buffer
            String in = b.readLine();
            System.out.println(in);

            ObjectInputStream rd = new ObjectInputStream(connection.getInputStream());//Create a Reply Object Buffer
            TeamMember member = (TeamMember) rd.readObject(); //Read Server Reply
            if(rd.available()>0) {
                System.out.println("Server replied: " + member.getName() + " .... " + member.getRate()); //Print the Server reply
            }
            br.close(); //close Request Buffer
            wr.close(); //close Reply Buffer
            b.close();
            rd.close();

            /***
             /* Close streams*/
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}