package com.company;

import java.io.*;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Client {

    public static void main(String args[]) throws UnknownHostException, IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in); // Create scanner to allow keyboard input
        int time = 1;
        while(true) {
            System.out.print("INFO: Enter 1 to register\n Enter 2 to login\n Enter ´q´ to stop session\n");
            String state = scanner.nextLine();
            if ("q".equals(state)) {
                System.out.println("Exit!"); // if keyboard input equal to ´q´ close client process
                break;
            }else if("1".equals(state)){
                System.out.print("Enter username :\n");
                String username = scanner.nextLine(); // Waiting for keyboard input
                if(username.isEmpty()){System.out.println("please enter a username"); username=scanner.nextLine();}
                System.out.println("Enter password :\n");
                String password = scanner.nextLine();
                if(password.isEmpty()){System.out.println("please enter a password"); password=scanner.nextLine();}
                System.out.println("Enter name :\n");
                String name = scanner.nextLine();
                if(name.isEmpty()){System.out.println("please enter a name"); name=scanner.nextLine();}

                System.out.println("Enter rate :\n");
                int rate = scanner.nextInt();
                if(rate == 0){System.out.println("please enter a rate = 1"); username=scanner.nextLine();}

                System.out.println("choose a role from (main role, part role 1, part role 2)");
                String role = scanner.nextLine();
                TeamMember member = new TeamMember(username,password,name,rate,role,state);
                ClientSocketTask clientRegistered = new ClientSocketTask(member); // create a new socket task
                clientRegistered.run(); //Run Task

            }else if("2".equals(state)){

                System.out.print("Enter username :\n");
                String username = scanner.nextLine(); // Waiting for keyboard input
                if(username.isEmpty()){System.out.println("please enter a username"); username=scanner.nextLine();}
                System.out.println("Enter password :\n");
                String password = scanner.nextLine();
                if(password.isEmpty()){System.out.println("please enter a password"); password=scanner.nextLine();}

                TeamMember member = new TeamMember(username,password,state);
                ClientSocketTask clientLogedIn = new ClientSocketTask(member);
                clientLogedIn.run(); //Run Task

            }else {
                System.out.println("Enter 1, 2 or q");
            }


        }
    }
}
