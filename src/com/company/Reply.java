package com.company;

import java.io.Serializable;

public class Reply implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private String e;

    public Reply(String username, String e) {
        super();
        this.username = username;
        this.e=e;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



}
