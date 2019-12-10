package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Team implements Serializable {
    private ArrayList teamMembers=new ArrayList();
    public Team(ArrayList teamMember){
        this.teamMembers=teamMember;
    }
    public ArrayList getTeamMembers() {
        return teamMembers;
    }
    public void setTeamMembers(ArrayList teamMembers) {
        this.teamMembers = teamMembers;
    }
}
