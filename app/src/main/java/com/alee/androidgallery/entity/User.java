package com.alee.androidgallery.entity;

public class User {
    public String uid;
    public String username;
    public String token;

    public User(String uid, String username, String token) {
        this.uid = uid;
        this.username = username;
        this.token = token;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
