package com.uagrm.instituto_backend.entities;

public class AuthData {

    private String token;
    private Usuario user;

    public AuthData(String token, Usuario user) {
        this.token = token;
        this.user = user;
    }
}