package com.afflorezc.view.components;

import java.awt.*;
import javax.swing.*;

public class ImageContainer extends JPanel{
    private Image image;
    private int width;
    private int height;
    private  boolean leftAlignment;

    public ImageContainer(String imageLocation, int width, int height, boolean leftAlignment) {
        this.height = height;
        this.width = width;
        this.leftAlignment = leftAlignment;

        image = new ImageIcon(imageLocation).getImage();

    }

    @Override
    public void paint(Graphics g){
        int x = 0;
        int y = 0;

        if(leftAlignment == false) {
            x = super.getWidth() - this.width;
        }

        g.drawImage(this.image, x, y, this.width, this.height, this);
        setOpaque(false);
        super.paint(g);
    }
}
