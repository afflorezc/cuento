package com.afflorezc.model;

public class VehicleInformation {

    private String tradeMark;
    private String description;
    private float price;
    private int power;
    private int cylinderCapacity;

    public VehicleInformation(String tradeMark, String description, float price, int power, int cylinderCapacity) {
        this.tradeMark = tradeMark;
        this.description = description;
        this.price = price;
        this.power = power;
        this.cylinderCapacity = cylinderCapacity;
    }

    public String getTradeMark() {
        return tradeMark;
    }

    public void setTradeMark(String tradeMark) {
        this.tradeMark = tradeMark;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getCylinderCapacity() {
        return cylinderCapacity;
    }

    public void setCylinderCapacity(int cylinderCapacity) {
        this.cylinderCapacity = cylinderCapacity;
    }
    
}
