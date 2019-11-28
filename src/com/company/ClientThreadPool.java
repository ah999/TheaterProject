package com.company;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientThreadPool {
    /**
     * * Created by PR on 07.11.2017.*/
    private static ExecutorService thPoolClient = Executors.newFixedThreadPool(1); //Create a pool of threads
    public static void main(String args[]) throws UnknownHostException, IOException {
        Scanner scanner = new Scanner(System.in); // Create scanner to allow keyboard input
        /*while(true) {
            System.out.print("INFO: Enter ´q´ to stop session\n");
            System.out.print("Enter message request to the server :   \n");
            String input = scanner.nextLine(); // Waiting for keyboard input
            if ("q".equals(input)) {
                System.out.println("Exit!"); // if keyboard input equal to ´q´ close client process
                break;
            }
            thPoolClient.execute(new ClientSocketTask(input)); //Start a task Thread to build a client request
        }*/
        while(true) {
            System.out.print("INFO: Enter 1 to register\n Enter 2 to login\n Enter ´q´ to stop session\n");
            String input = scanner.nextLine();
            if ("q".equals(input)) {
                System.out.println("Exit!"); // if keyboard input equal to ´q´ close client process
                break;
            }
            System.out.print("Enter username :   \n");
            String username = scanner.nextLine(); // Waiting for keyboard input
            System.out.println("Enter password :\n");
            String password = scanner.nextLine();
            TeamMember member = new TeamMember(username,password);
            thPoolClient.execute(new ClientSocketTask(member, input)); // create a new socket task
        }
        thPoolClient.shutdown(); //shutdown the ThreadPool
    }

}