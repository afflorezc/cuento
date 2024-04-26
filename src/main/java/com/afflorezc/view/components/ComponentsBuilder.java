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
/*
    public Container buildContainer(){

        Container panel = getContentPanel();
        panel.setBackground(styles.getBackGround());
    }
*/
}
