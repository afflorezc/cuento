package com.afflorezc.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.afflorezc.model.VehicleInformation;

import java.util.ArrayList;

public class selectMotorcicle extends JFrame {

    static final int GUI_WIDTH = 800;
	static final int GUI_HEIGHT = 500;
	static final int PADDING = 20;
    private  ArrayList<VehicleInformation> motorcicles;
    private int index = 0;
	Container ppalPanel;
    JPanel tittleLabel;
    JPanel selectionPanel;
    JPanel motorcicleInfo;
    JPanel motorcycleImage;

    public selectMotorcicle(ArrayList<VehicleInformation> motorcicles){

        super("Selección de moto");
        this.motorcicles = motorcicles;
        ppalPanel = getContentPane();
		ppalPanel.setBackground(new Color(255, 233, 173));
		GridLayout ppalLayout = new GridLayout();
		ppalLayout.setHgap(PADDING);
		ppalLayout.setVgap(PADDING);
		ppalPanel.setLayout(ppalLayout);

        // Tittle Label:
        tittleLabel = new JPanel();
        tittleLabel.setBackground(new Color(255, 233, 173));
        JLabel tittle = new JLabel("Seleccione una moto para Dante");
        tittle.setBackground(new Color(255,233,173));
        tittle.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
        tittle.setForeground(new Color(169,255,255));
        tittleLabel.add(tittle);

        // selection Panel
        selectionPanel = new JPanel();
        selectionPanel.setLayout(new GridLayout(1,2));
        selectionPanel.setBackground(new Color(255,233,173));
        // left side: Information
        motorcicleInfo = new JPanel();
        motorcicleInfo.setBackground(new Color(255,233,173));
        motorcicleInfo.setLayout(new BoxLayout(motorcicleInfo, BoxLayout.Y_AXIS));
        // Model info
        JLabel model = new JLabel();
        model.setBackground(new Color(255,233,173));
        model.setForeground(new Color(169,255,255));
        VehicleInformation currentMotorcicle = motorcicles.get(this.index);
        model.setText("Modelo: " + currentMotorcicle.getTradeMark() + " " + currentMotorcicle.getDescription());
        // Model info
        JLabel price = new JLabel();
        price.setBackground(new Color(255,233,173));
        price.setForeground(new Color(169,255,255));
        price.setText("Precio: " + currentMotorcicle.getPrice());


    }

    public static void main(String[] args) {
        new selectMotorcicle();
    }
}
