package com.company;

public class Script {
    String name;
    Team team;
    Integer rate;

    public Script(String name, Team team, Integer rate) {
        this.name = name;
        this.team = team;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }



}
