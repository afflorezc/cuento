package com.afflorezc.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.afflorezc.model.VehicleInformation;
import com.afflorezc.view.components.*;

import java.util.ArrayList;

public class SelectMotorcicle extends JFrame{

    static final int GUI_WIDTH = 800;
	static final int GUI_HEIGHT = 600;
	static final int PADDING = 20;
    static final String[] IMAGES = {"files\\img\\Kawasaki-z900.png", "files\\img\\kawasaki-zx-10r.png",
                                        "files\\img\\kawasaki zx-10r2.jpg", "files\\img\\kawasaki h2.jpg",
                                         "files\\img\\kawasaki-zx-10r-3.png"};
    private ComponentsBuilder builder;
    ArrayList<VehicleInformation> motorcicles;
    int index = 0;

	JPanel ppalPanel;
    JPanel tittlePanel;
    JLabel tittleLabel;
    JPanel selectionPanel;
    JPanel motorcicleInfo;
    JPanel motorcycleImage;

    public SelectMotorcicle(ArrayList<VehicleInformation> motorcicles, Styles styles){

        super("Selección de moto");
        builder = new ComponentsBuilder(styles);
        this.motorcicles = motorcicles;
        ppalPanel = builder.buildJPanel();
        this.setContentPane(ppalPanel);
		BoxLayout ppalLayout = new BoxLayout(ppalPanel, BoxLayout.Y_AXIS);
		ppalPanel.setLayout(ppalLayout);
        // Tittle Label:
        tittlePanel = builder.buildJPanel();
        tittleLabel = builder.buildJLabel("Seleccione una moto para Dante",true);
        tittlePanel.add(tittleLabel);
        //tittleLabel.setLocation(250, 4*styles.getPadding());
        tittleLabel.setSize(new Dimension(800,40));
        // selection Panel
        selectionPanel = builder.buildJPanel();
        selectionPanel.setLayout(new GridLayout(1,2,PADDING, PADDING));
        // left side: Information
        motorcicleInfo = builder.buildJPanel();
        motorcicleInfo.setLayout(new BoxLayout(motorcicleInfo, BoxLayout.Y_AXIS));
        // Model info
        JLabel model = builder.buildJLabel(false);
        VehicleInformation currentMotorcicle = motorcicles.get(this.index);
        model.setText("Modelo: " + currentMotorcicle.getTradeMark() + " " + currentMotorcicle.getDescription());
        // Price info
        JLabel price = builder.buildJLabel("Precio: " + currentMotorcicle.getPrice(), false);
        // Performance info
        JLabel power = builder.buildJLabel("Potencia: " +currentMotorcicle.getPower(), false);
        JLabel cylinderCap = builder.buildJLabel("Cilindraje: " +currentMotorcicle.getCylinderCapacity(), false);
        // add to infoPanel
        motorcicleInfo.add(model);
        motorcicleInfo.add(price);
        motorcicleInfo.add(power);
        motorcicleInfo.add(cylinderCap);
        //Right panel
        JPanel imagePanel = builder.buildJPanel();
        imagePanel.setLayout(new GridLayout(1, 3,PADDING, PADDING));
        // buttons
        JPanel leftBtnPanel = builder.buildJPanel();
        JPanel rightBtnPanel = builder.buildJPanel();
        JButton leftButton = builder.buildButton("Atrás");
        leftButton.addActionListener(new SelectionChange(this, false));
        leftBtnPanel.add(leftButton);
        JButton rightButton = builder.buildButton("Siguiente");
        rightButton.addActionListener(new SelectionChange(this, true));
        rightBtnPanel.add(rightButton);
        // Image
        ImageContainer motorcyclePhoto = new ImageContainer(IMAGES[index], 350, 250, true);
        // Add 
        imagePanel.add(leftBtnPanel);
        imagePanel.add(motorcyclePhoto);
        imagePanel.add(rightBtnPanel);
        // Add to ppalPanel
        selectionPanel.add(motorcicleInfo);
        selectionPanel.add(imagePanel);
        ppalPanel.add(tittlePanel);
        ppalPanel.add(selectionPanel);

        this.setSize(GUI_WIDTH + 2*PADDING, GUI_HEIGHT + 2*PADDING);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void updateMotorcicleData(){

        VehicleInformation motorcicle = this.motorcicles.get(index);

        JLabel model = (JLabel) this.motorcicleInfo.getComponent(0);
        JLabel price = (JLabel) this.motorcicleInfo.getComponent(1);
        JLabel power = (JLabel) this.motorcicleInfo.getComponent(2);
        JLabel cylinderCap = (JLabel) this.motorcicleInfo.getComponent(3);
        model.setText("Modelo " + motorcicle.getTradeMark() + " " + motorcicle.getDescription());
        price.setText("Precio: " + motorcicle.getPrice());
        power.setText("Potencia: " + motorcicle.getPower());
        cylinderCap.setText("Cilindraje: " + motorcicle.getCylinderCapacity());

        JPanel imagePanel = (JPanel) this.selectionPanel.getComponent(1);
        ImageContainer motoPhoto = (ImageContainer) imagePanel.getComponent(1);
        motoPhoto.setImage(IMAGES[index]);
        
    }

}

class SelectionChange implements ActionListener{

    SelectMotorcicle frame;
    boolean increase;
    public SelectionChange(SelectMotorcicle frame, boolean increase){
        this.frame = frame;
        this.increase = increase;
    }
    public void actionPerformed(ActionEvent e){
        if(increase){
            frame.index = (frame.index + 1) % frame.motorcicles.size();
        } else{
            frame.index += frame.motorcicles.size(); 
            frame.index = (frame.index - 1) % frame.motorcicles.size();
        }
        frame.updateMotorcicleData();
    }

}
