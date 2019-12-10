package com.company;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ServerSocketTask implements Runnable{
    /**
     * Created by PR on 07.11.2017. */

    private Socket connection;  // Create Socket
    static ArrayList RegisteredMemberList=new ArrayList();
    public ServerSocketTask(Socket s) {
        this.connection = s;
    }
    // ceate team members list
    private static Team registeredList = new Team(Server.teamList);
    TeamMember requestObj;

    public void createUserInfo(){
        String name;
        Integer rate;

    }

    @Override
    public void run() {
        try {
            /***
             *  Setting up input stream */

            ObjectInputStream wr = new ObjectInputStream(connection.getInputStream()); //Create a Request Object Buffer
            requestObj = (TeamMember) wr.readObject();
            ObjectOutputStream serverReply = new ObjectOutputStream(connection.getOutputStream()); //Create a Reply Buffer
            //Create Reply

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
            /***
             *  Setting up output stream */

            serverReply.close();
            wr.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
