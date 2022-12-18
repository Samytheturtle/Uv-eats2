package com.example.uv_eats.Activity.POCO;

import java.io.Serializable;

public class Auth implements Serializable {
    private String message;
    private String token;
    private int id;

    public Auth(String message, String token, int id)
    {
        this.message = message;
        this.token = token;
        this.id = id;
    }
    public Auth(){

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
