package com.company;

import java.io.*;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    /**
     * Created by PR on 07.11.2017.*/
    public static void main(String args[]) throws UnknownHostException, IOException {
        Scanner scanner = new Scanner(System.in); // Create scanner to allow keyboard input
        while(true) {
            System.out.print("INFO: Enter 1 to register\n Enter 2 to login\n Enter ´q´ to stop session\n");
            String input = scanner.nextLine();
            if ("q".equals(input)) {
                System.out.println("Exit!"); // if keyboard input equal to ´q´ close client process
                break;
            }else if("1".equals(input)){
                System.out.print("Enter username :\n");
                String username = scanner.nextLine(); // Waiting for keyboard input
                System.out.println("Enter password :\n");
                String password = scanner.nextLine();
                System.out.println("Enter name :\n");
                String name = scanner.nextLine();
                System.out.println("Enter rate :\n");
                String rate = scanner.nextLine();
                TeamMember member = new TeamMember(username,password,name,rate);
                ClientSocketTask clientRegistered = new ClientSocketTask(member, input); // create a new socket task
                clientRegistered.run(); //Run Task

            }else if("2".equals(input)){

                System.out.print("Enter username :\n");
                String username = scanner.nextLine(); // Waiting for keyboard input
                System.out.println("Enter password :\n");
                String password = scanner.nextLine();
                TeamMember member = new TeamMember(username, password);
                ClientSocketTask clientLogedIn = new ClientSocketTask(member, input);
                clientLogedIn.run(); //Run Task

            }else {
                System.out.println("Enter 1, 2 or q");
            }


        }
    }
}
