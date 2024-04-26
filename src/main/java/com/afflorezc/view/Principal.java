package com.afflorezc.view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import com.afflorezc.view.components.*;



public class Principal extends  JFrame{

    
    public Principal(){
        super("Principal");

        Container ppalPanel = getContentPane();

        ImageContainer sheldonPhoto = new ImageContainer("cuento\\src\\main\\java\\com\\afflorezc\\view\\images\\sheldonCern.png", 350, 250, true);
        ImageContainer dantePhoto = new ImageContainer("cuento\\src\\main\\java\\com\\afflorezc\\view\\images\\DevilMayCry3_figma.jpg", 350, 250, false);
        JButton buttonNext = new JButton("Siguiente");

        JPanel imagesPanel = new JPanel();
        imagesPanel.setLayout(new BoxLayout(imagesPanel, BoxLayout.X_AXIS));

        ppalPanel.setLayout(new BoxLayout(ppalPanel, BoxLayout.Y_AXIS));

        imagesPanel.add(sheldonPhoto);
        imagesPanel.add(dantePhoto);

        JPanel panelButton = new JPanel();
        panelButton.setLayout(new BoxLayout(panelButton, BoxLayout.X_AXIS));
    
        panelButton.add(buttonNext);

        buttonNext.setBackground(new Color(169, 0, 0));
        buttonNext.setForeground(new Color(169,255,255));
        buttonNext.setFocusPainted(false);
        buttonNext.setFont(new Font("DejaVu Sans", Font.PLAIN, 14));
        imagesPanel.setBackground(new Color(255, 233, 173));
        ppalPanel.setBackground(new Color(255, 233, 173));

        ppalPanel.add(imagesPanel);
        ppalPanel.add(panelButton);
        //this.add(ppalPanel);

        setLocation(300, 80);
        setVisible(true);
        setSize(800,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Principal();
    }

}

