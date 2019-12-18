package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Script {
    String name;
    int rate;
    ArrayList<String> roles =new ArrayList<String>();
    public Script(String name, int rate, ArrayList<String> roles) {
        this.name = name;
        this.rate = rate;
        this.roles = roles;
    }

    public Script(String name, int rate) {
        this.name = name;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getRate() {
        return rate;
    }
    public void setRate(int rate) {
        this.rate = rate;
    }

    public ArrayList<String> getRoles() { return roles; }
    public void setRoles(ArrayList<String> roles) { this.roles = roles; }



}
