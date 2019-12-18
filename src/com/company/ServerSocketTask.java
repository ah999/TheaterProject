package com.company;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ServerSocketTask implements Runnable{

    private Socket connection;  // Create Socket
    static ArrayList RegisteredMemberList=new ArrayList();
    public ServerSocketTask(Socket s) {
        this.connection = s;
    }
    // ceate team members list
    private static Team registeredList = new Team(Server.teamList);
    TeamMember requestObj;


    @Override
    public void run() {
        try {

            ObjectInputStream wr = new ObjectInputStream(connection.getInputStream()); //Create a Request Object Buffer
            requestObj = (TeamMember) wr.readObject();
            ObjectOutputStream serverReply = new ObjectOutputStream(connection.getOutputStream()); //Create a Reply Buffer

            if(requestObj.getState().equals("1")){
                registeredList.setTeamMembers(Server.teamList);
                serverReply.writeObject(requestObj);
            }else {
                for(TeamMember obj : Server.teamList){
                    if(obj.getUsername().equals(requestObj.getUsername())){
                        serverReply.writeObject(obj);
                    }else {
                        serverReply.writeObject(requestObj);
                    }
                }
                }

            serverReply.close();
            wr.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
