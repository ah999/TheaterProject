package com.company;

import java.io.Serializable;

public class TeamMember implements Serializable{

    String username;
    String password;
    String name;
    String rate;
    String rule;
    String script;
    String state;

    public TeamMember(){}

    public TeamMember(String username, String password, String state) {
        this.username = username;
        this.password = password;
        this.state = state;
    }

    public TeamMember(String username, String password,String name, String rate, String state) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.rate = rate;
        this.state = state;

    }

    public TeamMember(String name, String rate, String rule, String script){
        this.name = name;
        this.rate = rate;
        this.rule = rule;
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

    public void setRate(String rate){
        this.rate = rate;
    }
    public String getRate(){
        return rate;
    }

    public void setRule(String rule){
        this.rule = rule;
    }
    public String getRule(){
        return rule;
    }

    public void setScript(String script){
        this.script = script;
    }
    public String getScript(){
        return script;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


}
