package com.afflorezc.controller;

public class Item {

    private String id;
    private String itemName;
    private float basePrice;
    private float price;
    private float iva;

    public Item() {
    }

    public Item(String id, String itemName, float basePrice) {
        this.id = id;
        this.itemName = itemName;
        this.basePrice = basePrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(float price) {
        this.basePrice = price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

}
