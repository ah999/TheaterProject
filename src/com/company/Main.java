package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        TeamMember m1 = new TeamMember("u", "t", "1");
        TeamMember m2 = new TeamMember("w", "t", "1");
        TeamMember m3 = new TeamMember("s", "t", "1");
        ArrayList M = new ArrayList();
        M.add(m1);
        M.add(m2);
        M.add(m3);
        System.out.println(m1);
        if(M.contains(m1));
        {System.out.println(m1.getUsername());}

    }
}
