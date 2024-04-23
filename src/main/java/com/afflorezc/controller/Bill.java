package com.afflorezc.controller;

import java.util.ArrayList;

public class Bill {

    private static final float IVA = 0.19f;
    private static final int TOTAL_DIGITS = 4;
    private static int number = 0;
    private float price;
    private float basePrice;
    private float ivaValue;
    private ArrayList<Item> items;
    private String companyName;
    private String companyNIT;
    private String companyAddress;
    private String companyTel;
    private String billNumber;

    public Bill(String companyName, String companyNIT, String companyAddress, String companyTel){
        
        price = 0.0f;
        basePrice = 0.0f;
        ivaValue = 0.0f;
        items = new ArrayList<Item>();
        this.companyName = companyName;
        this.companyNIT = companyNIT;
        this.companyAddress = companyAddress;
        this.companyTel = companyTel;
        setBillNumber();
        
    }

    private void setBillNumber(){
        
        number++;
        billNumber =""+number;
        int digits = billNumber.length();
        int zeroDigits = TOTAL_DIGITS - digits;
        String zeroes ="";

        for(int i=0;i<zeroDigits;i++){
            zeroes += "0";
        }
        billNumber = zeroes + billNumber;
    }

    public void calculateBasePrice(){

        for(Item item:items){
            basePrice += item.getBasePrice();
        }
    }

    public void calculateIVA(){

        for(Item item:items){
            float itemIva = IVA*item.getBasePrice();
            item.setIva(itemIva);
            ivaValue += itemIva;
        }

    }

    public void addItem(Item item){

        items.add(item);
    }

    public float getPrice() {
        return price;
    }

    public float getBasePrice() {
        return basePrice;
    }

    public float getIvaValue() {
        return ivaValue;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyNIT() {
        return companyNIT;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public String getCompanyTel() {
        return companyTel;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void printBill(){
        // Imprime información encabezado
        
    }

}
