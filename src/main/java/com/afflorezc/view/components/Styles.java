package com.afflorezc.view.components;

import java.awt.*;

public class Styles {

    private Color backGround;
    private Color buttonBackGround;
    private Color foreGround;
    private Color buttonForeGround;
    private Font tittlesFont;
    private Font contentFont;
    private Font buttonFont;
    private int padding;

    public Styles(Color backGround, Color foreGround, Color buttonBackGround, Color buttonForeGround,
                      Font tittlesFont, Font contentFont, Font buttonFont, int padding) {
        
        this.backGround = backGround;
        this.buttonBackGround = buttonBackGround;
        this.foreGround = foreGround;
        this.buttonForeGround = buttonForeGround;
        this.tittlesFont = tittlesFont;
        this.contentFont = contentFont;
        this.buttonFont = buttonFont;
        this.padding = padding;
    }

    public Color getBackGround() {
        return backGround;
    }

    public void setBackGround(Color backGround) {
        this.backGround = backGround;
    }

    public Color getForeGround() {
        return foreGround;
    }

    public void setForeGround(Color foreGround) {
        this.foreGround = foreGround;
    }

    public Font getTittlesFont() {
        return tittlesFont;
    }

    public void setTittlesFont(Font tittlesFont) {
        this.tittlesFont = tittlesFont;
    }

    public Font getContentFont() {
        return contentFont;
    }

    public void setContentFont(Font contentFont) {
        this.contentFont = contentFont;
    }

    public int getPadding() {
        return padding;
    }

    public void setPadding(int padding) {
        this.padding = padding;
    }

    public Color getButtonBackGround() {
        return buttonBackGround;
    }

    public void setButtonBackGround(Color buttonBackGround) {
        this.buttonBackGround = buttonBackGround;
    }

    public Color getButtonForeGround() {
        return buttonForeGround;
    }

    public void setButtonForeGround(Color buttonForeGround) {
        this.buttonForeGround = buttonForeGround;
    }

    public Font getButtonFont() {
        return buttonFont;
    }

    public void setButtonFont(Font buttonFont) {
        this.buttonFont = buttonFont;
    }

}
