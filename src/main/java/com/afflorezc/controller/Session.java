package com.afflorezc.controller;

public class Session {
    private String name;
    private int numberReadings;
    private String password;

    public Session(String name, String password) {
        this.name = name;
        this.numberReadings = 0;
        this.password = password;
    }

    public void increaseNumberReadings(){
        this.numberReadings++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberReadings() {
        return numberReadings;
    }

    public void setNumberReadings(int numberReadings) {
        this.numberReadings = numberReadings;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
