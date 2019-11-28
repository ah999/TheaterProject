package com.company;

import java.io.Serializable;

public class Request implements Serializable{

    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private String state;

    public Request(String username, String password, String state) {
        super();
        this.username = username;
        this.password = password;
        this.state = state;
    }



    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
