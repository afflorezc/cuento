package com.afflorezc.view;

import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

import com.afflorezc.controller.LocalPaths;
import com.afflorezc.model.VehicleInformation;

public class MotoSelection extends JFrame {

    int xMouse, yMouse;

    static final String[] IMAGES = {LocalPaths.IMAGESPATH+"Kawasaki-z900.png", LocalPaths.IMAGESPATH+"kawasaki-zx-10r.png",
                                    LocalPaths.IMAGESPATH+"kawasaki zx-10r2.png", LocalPaths.IMAGESPATH+"kawasaki h2.png",
                                    LocalPaths.IMAGESPATH+"kawasaki-zx-10r-3.png"};

    ArrayList<VehicleInformation> motorcicles;
    int index = 0;
    
    private JLabel backButton;
    private JPanel background;
    private JLabel cylinderInfo;
    private JLabel cylinderLabel;
    private JLabel exitButton;
    private JLabel imageContainer;
    private JLabel backgroundImage;
    private JLabel modelInfo;
    private JLabel modelLabel;
    private JLabel nextButton;
    private JLabel powerInfo;
    private JLabel powerLabel;
    private JLabel priceInfo;
    private JLabel priceLabel;
    private JLabel tittleLabel;
    private JPanel upperPanel;
    
    public MotoSelection(ArrayList<VehicleInformation> motorcicles) {

        this.motorcicles = motorcicles;
        index = 0;
        initComponents();
        this.updateMotorcicleData();
        VehicleInformation currentMotorcicle = motorcicles.get(index);
        modelInfo.setText(currentMotorcicle.getTradeMark() + " " + currentMotorcicle.getDescription());
        powerInfo.setText("" + currentMotorcicle.getPower());
        cylinderInfo.setText("" + currentMotorcicle.getCylinderCapacity());
        priceInfo.setText("" + currentMotorcicle.getPrice());

    }

    public void updateMotorcicleData(){

        VehicleInformation currentMotorcicle = this.motorcicles.get(index);

        modelInfo.setText(currentMotorcicle.getTradeMark() + " " + currentMotorcicle.getDescription());
        powerInfo.setText("" + currentMotorcicle.getPower());
        cylinderInfo.setText("" + currentMotorcicle.getCylinderCapacity());
        priceInfo.setText("" + currentMotorcicle.getPrice());
        Image motoPicture = new ImageIcon(IMAGES[index]).getImage();
        imageContainer.setIcon(new ImageIcon(motoPicture));

    }
    
    private void initComponents() {

        background = new javax.swing.JPanel();
        tittleLabel = new javax.swing.JLabel();
        modelLabel = new javax.swing.JLabel();
        powerLabel = new javax.swing.JLabel();
        cylinderLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        modelInfo = new javax.swing.JLabel();
        powerInfo = new javax.swing.JLabel();
        cylinderInfo = new javax.swing.JLabel();
        priceInfo = new javax.swing.JLabel();
        backButton = new javax.swing.JLabel();
        nextButton = new javax.swing.JLabel();
        imageContainer = new JLabel();
        upperPanel = new javax.swing.JPanel();
        exitButton = new javax.swing.JLabel();
        backgroundImage = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setLocationRelativeTo(null);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tittleLabel.setFont(new java.awt.Font("High Tower Text", 0, 36)); // NOI18N
        tittleLabel.setForeground(new java.awt.Color(138, 43, 43));
        tittleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tittleLabel.setText("Seleccione una Moto para Dante");
        background.add(tittleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 800, 40));

        modelLabel.setFont(new java.awt.Font("High Tower Text", 0, 18)); // NOI18N
        modelLabel.setForeground(new java.awt.Color(255, 255, 255));
        modelLabel.setText("Modelo      :");
        background.add(modelLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 90, 20));

        powerLabel.setFont(new java.awt.Font("High Tower Text", 0, 18)); // NOI18N
        powerLabel.setForeground(new java.awt.Color(255, 255, 255));
        powerLabel.setText("Potencia    :");
        background.add(powerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 90, 20));

        cylinderLabel.setFont(new java.awt.Font("High Tower Text", 0, 18)); // NOI18N
        cylinderLabel.setForeground(new java.awt.Color(255, 255, 255));
        cylinderLabel.setText("Cilindraje :");
        background.add(cylinderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 90, 20));

        priceLabel.setFont(new java.awt.Font("High Tower Text", 0, 18)); // NOI18N
        priceLabel.setForeground(new java.awt.Color(255, 255, 255));
        priceLabel.setText("Precio         :");
        background.add(priceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 90, 20));

        modelInfo.setBackground(new java.awt.Color(255, 255, 255));
        modelInfo.setFont(new java.awt.Font("High Tower Text", 0, 18)); // NOI18N
        modelInfo.setForeground(new java.awt.Color(255, 255, 255));
        modelInfo.setText("modelInfo");
        background.add(modelInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 600, 20));

        powerInfo.setFont(new java.awt.Font("High Tower Text", 0, 18)); // NOI18N
        powerInfo.setForeground(new java.awt.Color(255, 255, 255));
        powerInfo.setText("powerInfo");
        background.add(powerInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 600, 20));

        cylinderInfo.setFont(new java.awt.Font("High Tower Text", 0, 18)); // NOI18N
        cylinderInfo.setForeground(new java.awt.Color(255, 255, 255));
        cylinderInfo.setText("cylinderInfo");
        background.add(cylinderInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 600, 20));

        priceInfo.setFont(new java.awt.Font("High Tower Text", 0, 18)); // NOI18N
        priceInfo.setForeground(new java.awt.Color(255, 255, 255));
        priceInfo.setText("priceInfo");
        priceInfo.setToolTipText("");
        background.add(priceInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 600, 20));

        backButton.setFont(new java.awt.Font("High Tower Text", 1, 48)); // NOI18N
        backButton.setForeground(new java.awt.Color(138, 43, 43));
        backButton.setText("<");
        backButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backButtonMouseExited(evt);
            }
        });
        background.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 30, -1));

        nextButton.setFont(new java.awt.Font("High Tower Text", 1, 48)); // NOI18N
        nextButton.setForeground(new java.awt.Color(138, 43, 43));
        nextButton.setText(">");
        nextButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nextButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nextButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nextButtonMouseExited(evt);
            }
        });
        background.add(nextButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 330, 30, -1));

        imageContainer.setBackground(new java.awt.Color(255, 255, 255));
        imageContainer.setOpaque(false);

        javax.swing.GroupLayout imageContainerLayout = new javax.swing.GroupLayout(imageContainer);
        imageContainer.setLayout(imageContainerLayout);
        imageContainerLayout.setHorizontalGroup(
            imageContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        imageContainerLayout.setVerticalGroup(
            imageContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        background.add(imageContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 350, 250));

        upperPanel.setOpaque(false);
        upperPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                upperPanelMouseDragged(evt);
            }
        });
        upperPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                upperPanelMousePressed(evt);
            }
        });

        exitButton.setBackground(new java.awt.Color(255, 255, 255));
        exitButton.setFont(new java.awt.Font("High Tower Text", 0, 18)); // NOI18N
        exitButton.setForeground(new java.awt.Color(255, 255, 255));
        exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exitButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitButton.setText("X");
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitButtonMouseExited(evt);
            }
        });

        javax.swing.GroupLayout upperPanelLayout = new javax.swing.GroupLayout(upperPanel);
        upperPanel.setLayout(upperPanelLayout);
        upperPanelLayout.setHorizontalGroup(
            upperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, upperPanelLayout.createSequentialGroup()
                .addGap(0, 760, Short.MAX_VALUE)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        upperPanelLayout.setVerticalGroup(
            upperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        background.add(upperPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 30));
        
        Image backgroundPicture = new ImageIcon(LocalPaths.IMAGESPATH+"workshopScene.jpg").getImage();

        backgroundImage.setIcon(new ImageIcon(backgroundPicture)); 
        backgroundImage.setToolTipText("");
        backgroundImage.setMaximumSize(new java.awt.Dimension(800, 600));
        backgroundImage.setMinimumSize(new java.awt.Dimension(800, 600));
        backgroundImage.setPreferredSize(new java.awt.Dimension(800, 600));
        background.add(backgroundImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                               

    private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {                                        
       
        this.index = (this.index + 1) % this.motorcicles.size();
        this.updateMotorcicleData();
    }                                       

    private void nextButtonMouseClicked(java.awt.event.MouseEvent evt) {                                        
       
        this.index += this.motorcicles.size(); 
        this.index = (this.index - 1) % this.motorcicles.size();
        this.updateMotorcicleData();
    }                                       

    private void backButtonMouseEntered(java.awt.event.MouseEvent evt) {                                        
        this.backButton.setForeground(Color.red);
    }                                       

    private void backButtonMouseExited(java.awt.event.MouseEvent evt) {                                       
        this.backButton.setForeground(new Color(138,43,43));
    }                                      

    private void nextButtonMouseEntered(java.awt.event.MouseEvent evt) {                                        
        this.nextButton.setForeground(Color.red);
    }                                       

    private void nextButtonMouseExited(java.awt.event.MouseEvent evt) {                                       
        this.nextButton.setForeground(new Color(138,43,43));
    }                                      

    private void exitButtonMouseClicked(java.awt.event.MouseEvent evt) {                                        
        System.exit(0);
    }                                       

    private void exitButtonMouseEntered(java.awt.event.MouseEvent evt) {                                        
        this.exitButton.setForeground(Color.red);
    }                                       

    private void exitButtonMouseExited(java.awt.event.MouseEvent evt) {                                       
        this.exitButton.setForeground(new Color(138,43,43));
    }                                      

    private void upperPanelMousePressed(java.awt.event.MouseEvent evt) {                                      
        xMouse = evt.getX();
        yMouse = evt.getY();
    }                                     

    private void upperPanelMouseDragged(java.awt.event.MouseEvent evt) {                                      
       
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xMouse, y-yMouse);
    }
}  
