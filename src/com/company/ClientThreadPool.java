package com.company;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientThreadPool {
    /**
     * * Created by PR on 07.11.2017.*/
    private static ExecutorService thPoolClient = Executors.newFixedThreadPool(15); //Create a pool of threads
    public static void main(String args[]) throws UnknownHostException, IOException {
        Scanner scanner = new Scanner(System.in); // Create scanner to allow keyboard input

        while(true) {
            System.out.print("INFO: Enter 1 to register\n Enter 2 to login\n Enter ´q´ to stop session\n");
            String state = scanner.nextLine();
            if ("q".equals(state)) {
                System.out.println("Exit!"); // if keyboard input equal to ´q´ close client process
                break;
            }else if("1".equals(state)){
                System.out.print("Enter username :\n");
                String username = scanner.nextLine(); // Waiting for keyboard input
                System.out.println("Enter password :\n");
                String password = scanner.nextLine();
                System.out.println("Enter name :\n");
                String name = scanner.nextLine();
                System.out.println("Enter rate :\n");
                String rate = scanner.nextLine();
                TeamMember member = new TeamMember(username,password,name,rate,state);
                thPoolClient.execute(new ClientSocketTask(member)); // create a new socket task

            }else if("2".equals(state)){

                System.out.print("Enter username :\n");
                String username = scanner.nextLine(); // Waiting for keyboard input
                System.out.println("Enter password :\n");
                String password = scanner.nextLine();
                TeamMember member = new TeamMember(username, password, state);
                thPoolClient.execute(new ClientSocketTask(member)); // create a new socket task

            }else {
                System.out.println("Enter 1, 2 or q");
            }
            thPoolClient.shutdown(); //shutdown the ThreadPool


        }
    }
}



