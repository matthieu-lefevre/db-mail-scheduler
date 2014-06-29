package com.mlefevre.scheduler.mail.model;

public class Credentials {

    protected String username;

    protected String password;


    public Credentials(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
