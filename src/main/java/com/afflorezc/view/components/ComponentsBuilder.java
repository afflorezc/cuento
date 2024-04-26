package com.afflorezc.view.components;

import java.awt.*;
import javax.swing.*;

public class ComponentsBuilder {

    private Styles styles;

    public ComponentsBuilder(Styles styles){
        this.styles = styles;
    }

    public JLabel buildJLabel(boolean isTittle){
        
        JLabel label = new JLabel();
        label.setBackground(styles.getBackGround());
        label.setForeground(styles.getForeGround());
        if(isTittle){
            label.setFont(styles.getTittlesFont());
        } else{
            label.setFont(styles.getContentFont());
        }
        
        return label;
    }

    public JLabel buildJLabel(String text, boolean isTittle){
        
        JLabel label = this.buildJLabel(isTittle);
        label.setText(text);
        return label;
    }

    public Container buildContainer(){

        Container panel = new Container();
        panel.setBackground(styles.getBackGround());
        
        if(!panel.isOpaque()){
            System.out.println("No es opaco!");
        }
        return panel;
    }

    public JPanel buildJPanel(){

        JPanel panel = new JPanel();
        panel.setBackground(styles.getBackGround());
        return panel;
    }

    public JButton buildButton(){

        JButton button = new JButton();
        button.setBackground(styles.getButtonBackGround());
        button.setForeground(styles.getButtonForeGround());
        button.setFont(styles.getButtonFont());
        button.setFocusPainted(false);
        button.setSize(50, 15);
        return button;
    }

    public JButton buildButton(String text){

        JButton button = this.buildButton();
        button.setText(text);
        return button;
    }

}
