package com.example.tier1Mediator;

public class User {
    public String username;
    public String password;
    public int securityLevel;

    public User(String username, String password, int securityLevel){
        this.password = password;
        this.username = username;
        this.securityLevel = securityLevel;
    }
}
