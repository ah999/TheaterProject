package com.company;

import java.beans.beancontext.BeanContextMembershipEvent;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;


public class Server {

    private static Socket connection;  // Create Socket
    private static ServerSocket serverSocket;   // Create a Server Socket
    static ArrayList<TeamMember> teamList = new ArrayList<TeamMember>();
    static ArrayList <Script> scriptList = new ArrayList<Script>();
    static ArrayList<String> roles =new ArrayList<String>();
    Random r =new Random();
    public static void main(String[] args) throws IOException {
        int port = 1234; // initialize port number
        serverSocket = new ServerSocket(port);// Start a new server socket
        roles.add("main role");
        roles.add("part role 1");
        roles.add("part role 2");
        Script s1 = new Script("Hamlet", 3, roles);
        Script s2 = new Script("Makbeth", 2,roles);
        Script s3 = new Script("Romio and Juliet", 1,roles);
        Script s4 = new Script("Othello", 3);
        Script s5 = new Script("Julius Ceaser", 4,roles);
        scriptList.add(s1);
        scriptList.add(s2);
        scriptList.add(s3);
        scriptList.add(s4);
        scriptList.add(s5);

        while (true) {

            System.out.println("wait for connections");
            connection = serverSocket.accept(); // Wait and create new connection if a client request arrives
            ServerSocketTask serverTask = new ServerSocketTask(connection); // create a new socket task
            serverTask.run(); // Run Task
            if(serverTask.requestObj.getState().equals("1")){
                teamList.add(serverTask.requestObj);
            }
            if(teamList.size()>=3){
                createTeam();
                System.out.println(teamList);

            }
            connection.close(); // close Socket connection
        }
    }

    private static TeamMember getRandomMember(){
        int memberIndex = new Random().nextInt(teamList.size());
        TeamMember member = teamList.get(memberIndex);
        teamList.remove(memberIndex);
        return member;
    }
    private static void incrementRate(TeamMember m){
        int r = m.getRate()+1;
        m.setRate(r);
        teamList.add(m);
    }
    private static void createTeam() {
        ArrayList<TeamMember> team = new ArrayList<TeamMember>();
        Team T = new Team();
        int rateSum = 0;
        for (int i = 0; i < 3; i++) {
            TeamMember m = getRandomMember();
            team.add(m);
            incrementRate(m);
        }
        for (TeamMember m : team) {
            int i = m.getRate();
            rateSum += i;
        }
        Double avgR = new Double(rateSum / 3);
        int avgRate = avgR.intValue();
        for (Script script : scriptList) {
            if (avgRate == script.getRate()) {
                T = new Team(team, avgRate, script);
                for(TeamMember m : team){
                    m.setScript(script.getName());
                    int index = new Random().nextInt(roles.size());
                    String role = roles.get(index);
                    System.out.println(role);
                    m.setRole(role);
                }
            }
        }
    }

}
