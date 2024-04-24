package com.afflorezc.view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import com.afflorezc.view.components.*;



public class Principal extends  JFrame{

    public Principal(){
        super("Principal");


        JPanel panel = new JPanel();

        ImageContainer fotoSheldon = new ImageContainer("cuento\\src\\main\\java\\com\\afflorezc\\view\\images\\sheldonCern.png", 350, 250, true);
        ImageContainer fotoDante = new ImageContainer("cuento\\src\\main\\java\\com\\afflorezc\\view\\images\\DevilMayCry3_figma.jpg", 350, 250, false);

        JButton buttonNext = new JButton("Siguiente");

        JPanel imagesPanel = new JPanel();
        imagesPanel.setLayout(new BoxLayout(imagesPanel, BoxLayout.X_AXIS));

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        imagesPanel.add(fotoSheldon);
        imagesPanel.add(fotoDante);

        JPanel panelButton = new JPanel();
        panelButton.setLayout(new BoxLayout(panelButton, BoxLayout.X_AXIS));

        panelButton.add(buttonNext);

        buttonNext.setBackground(new Color(169, 0, 0));
        //buttonNext.setFont(new Font());


        panel.add(imagesPanel);
        panel.add(panelButton);

        this.add(panel);

        imagesPanel.setBackground(new Color(243,232,202));
        panel.setBackground(new Color(243,232,202));

        setLocation(300, 80);
        setVisible(true);
        setSize(800,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Principal pantalla = new Principal();
    }

}

