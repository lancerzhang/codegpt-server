package com.example.codegptserver.models;

public class Session {
    private int chats;
    private int tokens;

    public int getChats() {
        return chats;
    }

    public void setChats(int chats) {
        this.chats = chats;
    }

    public int getTokens() {
        return tokens;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }
}