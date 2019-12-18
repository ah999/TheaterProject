package com.company;

import java.io.Serializable;

public class TeamMember implements Serializable{

    String username;
    String password;
    String name;
    int rate;
    String role;
    String script;
    String state;

    public TeamMember(){}

    public TeamMember(String username, String password, String state) {
        this.username = username;
        this.password = password;
        this.state = state;
    }

    public TeamMember(String username, String password,String name, int rate,String role, String state) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.rate = rate;
        this.role=role;
        this.state = state;

    }

    public TeamMember(String name, int rate, String role, String script){
        this.name = name;
        this.rate = rate;
        this.role = role;
        this.script = script;

    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String clientName) {
        this.username = clientName;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String operation) {
        this.password = operation;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setRate(int rate){
        this.rate = rate;
    }
    public int getRate(){
        return rate;
    }

    public void setRole(String rule){
        this.role = rule;
    }
    public String getRole(){
        return role;
    }

    public void setScript(String script){
        this.script = script;
    }
    public String getScript(){
        return script;
    }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }


}
