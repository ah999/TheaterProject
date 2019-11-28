package com.company;

import java.io.Serializable;

public class TeamMember implements Serializable{

    String username;
    String password;
    String name;
    Double rate;
    String rule;
    String script;

    public TeamMember(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public TeamMember(String username, String password,String name, String rate) {
        this.username = username;
        this.password = password;
    }

    public TeamMember(String name, Double rate, String rule, String script){
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

    public void setRate(Double rate){
        this.rate = rate;
    }
    public Double getRate(){
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

}
