package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Team implements Serializable {
    private ArrayList teamMembers=new ArrayList();
    private int avgRate;
    private Script script;

    public Team(){}
    public Team(ArrayList teamMembers){
        this.teamMembers=teamMembers;
    }

    public Team(ArrayList teamMember, int avgRate, Script script){
        this.teamMembers=teamMember;
        this.avgRate=avgRate;
        this.script=script;
    }
    public ArrayList getTeamMembers() {
        return teamMembers;
    }
    public void setTeamMembers(ArrayList teamMembers) {
        this.teamMembers = teamMembers;
    }

    public int getAvgRate() { return avgRate; }
    public void setAvgRate(int avgRate) {
        this.avgRate = avgRate;
    }

    public Script getScript() { return script; }
    public void setScript(Script script) {
        this.script = script;
    }

}
