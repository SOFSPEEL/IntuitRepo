package com.example.intuitrepos.dto;

public class Creds {
   private String username;
   private String password;

    public Creds(String username, String password) {

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
