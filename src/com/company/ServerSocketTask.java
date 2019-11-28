package com.company;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ServerSocketTask implements Runnable{
    /**
     * Created by PR on 07.11.2017. */

    private Socket connection;  // Create Socket
    public ServerSocketTask(Socket s) {
        this.connection = s;
    }

    // ceate team members list
    ArrayList RegisteredMemberList=new ArrayList();
    Team registeredList = new Team();
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
            System.out.println("go");

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream())); //Create a Request Buffer
            String in = br.readLine();
            ObjectInputStream wr = new ObjectInputStream(connection.getInputStream()); //Create a Request Object Buffer
            System.out.println("go");
            requestObj = (TeamMember) wr.readObject();
            System.out.println("go");

            BufferedWriter b = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
            ObjectOutputStream serverReply = new ObjectOutputStream(connection.getOutputStream()); //Create a Reply Buffer
            //Create Reply

            if(in.equals("1")){
                // add the nonregistered member to the registeration list
                RegisteredMemberList.add(requestObj);
                registeredList.setTeamMembers(RegisteredMemberList);
                b.write("member is signed successfully!"+"\n");
                b.flush();
            }else {
                if(RegisteredMemberList.contains(requestObj)){
                    Integer index = RegisteredMemberList.indexOf(requestObj);
                    TeamMember wrr = (TeamMember) RegisteredMemberList.get(index);
                    b.write(" The member is"+"\n");
                    b.flush();
                    serverReply.writeObject(wrr);
                    serverReply.flush();
                }
                }
            /***
             *  Setting up output stream */
            //Create Reply
            b.close();
            serverReply.close();
            wr.close();
            br.close();
        } catch (IOException | ClassNotFoundException  e) {
            e.printStackTrace();
        }
    }
}
