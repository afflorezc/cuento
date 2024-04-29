package com.afflorezc.view.components;

import java.awt.*;
import javax.swing.*;

public class ImageContainer extends JPanel{
    //CONSTANTES
    static public final int RIGHTALIGNMENT = 1;
    static public final int LEFTALIGNMENT = -1;
    static public final int TOPALIGNMENT = 1;
    static public final int BOTTOMALIGNMENT = -1;
    static public final int CENTERALIGNMENT = 0;


    // VARIABLES
    private Image image;
    private int imageWidth;
    private int imageHeight;
    private int verticalAlingment;
    private int horizonralAlingment;
    private boolean widthAutoSizeable;
    private boolean heightAutoSizeable;
    private float widthAdjustmentPercent;
    private  float heightAdjustmentPercent;


    // constructores

    public ImageContainer(String imageLocation, int width, int height) {
        this.imageHeight = height;
        this.imageWidth = width;

        this.heightAutoSizeable = false;
        this.widthAutoSizeable = false;

        this.verticalAlingment = ImageContainer.TOPALIGNMENT;
        this.horizonralAlingment = ImageContainer.LEFTALIGNMENT;

        this.image = new ImageIcon(imageLocation).getImage();
    }

    public ImageContainer(String imageLocation) {
        this.image = new ImageIcon(imageLocation).getImage();

        this.widthAdjustmentPercent = 1;
        this.heightAdjustmentPercent = 1;

        this.heightAutoSizeable = true;
        this.widthAutoSizeable = true;
    }

    public ImageContainer(Image image, float widthAdjustmentPercent, float heightAdjustmentPercent) {
        this.image = image;
        setWidthAdjustmentPercent(widthAdjustmentPercent);
        setHeightAdjustmentPercent(heightAdjustmentPercent);

        this.heightAutoSizeable = true;
        this.widthAutoSizeable = true;
    }

    // Getter y Setters

    public void setImage(String imageLocation){
        this.image = new ImageIcon(imageLocation).getImage();
        this.repaint();
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    public String getVerticalAlingment() {
        String alingment;
        switch (verticalAlingment){
            case ImageContainer.TOPALIGNMENT:
                alingment = "top";
                break;
            case ImageContainer.CENTERALIGNMENT:
                alingment = "center";
                break;
            case ImageContainer.BOTTOMALIGNMENT:
                alingment = "bottom";
                break;
            default:
                alingment = "error";
                break;
        }

        return  alingment;
    }

    public void setVerticalAlingment(int verticalAlingment) {
        if (verticalAlingment == ImageContainer.TOPALIGNMENT ||
                verticalAlingment == ImageContainer.BOTTOMALIGNMENT ||
                verticalAlingment == ImageContainer.CENTERALIGNMENT){

            this.verticalAlingment = verticalAlingment;

        }else{
            this.verticalAlingment = ImageContainer.TOPALIGNMENT;
        }
    }

    public String getHorizonralAlingment() {
        String alingment;
        switch (horizonralAlingment){
            case ImageContainer.LEFTALIGNMENT:
                alingment = "left";
                break;
            case ImageContainer.CENTERALIGNMENT:
                alingment = "center";
                break;
            case ImageContainer.RIGHTALIGNMENT:
                alingment = "right";
                break;
            default:
                alingment = "error";
                break;
        }

        return  alingment;
    }

    public void setHorizonralAlingment(int horizonralAlingment) {
        if (horizonralAlingment == ImageContainer.LEFTALIGNMENT ||
                horizonralAlingment == ImageContainer.RIGHTALIGNMENT ||
                horizonralAlingment == ImageContainer.CENTERALIGNMENT){

            this.horizonralAlingment = horizonralAlingment;

        }else{
            this.horizonralAlingment = ImageContainer.LEFTALIGNMENT;
        }
    }

    public boolean isWidthAutoSizeable() {
        return widthAutoSizeable;
    }

    public void setWidthAutoSizeable(float widthAdjustmentPercent) {
        this.widthAutoSizeable = true;
        setWidthAdjustmentPercent(widthAdjustmentPercent);
    }

    public void setWidthNoAutoSizeable(int imageWidth) {
        this.widthAutoSizeable = false;
        setImageWidth(imageWidth);
    }

    public boolean isHeightAutoSizeable() {
        return heightAutoSizeable;
    }

    public void setHeightAutoSizeable(float heightAdjustmentPercent) {
        this.heightAutoSizeable = true;
        setHeightAdjustmentPercent(heightAdjustmentPercent);
    }

    public void setHeightNoAutoSizeable(int imageHeight) {
        this.heightAutoSizeable = false;
        setImageHeight(imageHeight);
    }

    public float getWidthAdjustmentPercent() {
        return widthAdjustmentPercent;
    }

    public void setWidthAdjustmentPercent(float widthAdjustmentPercent) {
        if (1 >= widthAdjustmentPercent && widthAdjustmentPercent >= 0){
            this.widthAdjustmentPercent = widthAdjustmentPercent;
        }else if (100 >= widthAdjustmentPercent && widthAdjustmentPercent > 1){
            this.widthAdjustmentPercent = widthAdjustmentPercent/100;
        }else{
            this.widthAdjustmentPercent = 1;
        }
    }

    public float getHeightAdjustmentPercent() {
        return heightAdjustmentPercent;
    }

    public void setHeightAdjustmentPercent(float heightAdjustmentPercent) {
        if (1 >= heightAdjustmentPercent && heightAdjustmentPercent >= 0){
            this.heightAdjustmentPercent = heightAdjustmentPercent;
        }else if (100 >= heightAdjustmentPercent && heightAdjustmentPercent > 1){
            this.heightAdjustmentPercent = heightAdjustmentPercent/100;
        }else{
            this.heightAdjustmentPercent = 1;
        }
    }

    private int[] getCoords(){
        int[] initCoords = {0,0};
        int xCoord;
        int yCoord;

        int[] size = getImageSize();

        int imageWidth = size[0];
        int imageHeigth = size[1];

        switch (getHorizonralAlingment()){
            case "left":
                xCoord = 0;
                break;
            case "center":
                xCoord = (int) ((super.getWidth()-imageWidth)/2);
                break;
            case "right":
                xCoord = super.getWidth()-imageWidth;
                break;
            default:
                xCoord = 0;
                break;
        }

        initCoords[0] = xCoord;

        switch (getVerticalAlingment()){
            case "top":
                yCoord = 0;
                break;
            case "center":
                yCoord = (int) ((super.getHeight()-imageHeigth)/2);
                break;
            case "bottom":
                yCoord = super.getHeight()-imageHeigth;
                break;
            default:
                yCoord = 0;
                break;
        }

        initCoords[1] = yCoord;

        return initCoords;
    }

    private int[] getImageSize(){
        int[] size = {0,0};

        if (isWidthAutoSizeable()){
            size[0] = (int) (getWidthAdjustmentPercent()*super.getWidth());
        }else{
            size[0] = getImageWidth();
        }

        if (isHeightAutoSizeable()){
            size[1] = (int) (getHeightAdjustmentPercent()*super.getHeight());
        }else{
            size[1] = getImageHeight();
        }

        return size;
    }

    @Override
    public void paint(Graphics g){
        int[] size = getImageSize();
        int[] initCoords = getCoords();

        int currentWidth = size[0];
        int currentHeight = size[1];
        int x = initCoords[0];
        int y = initCoords[1];

        g.drawImage(this.image, x, y, currentWidth, currentHeight, this);
        setOpaque(false);
        super.paint(g);
    }
}
