package com.afflorezc.view;

import java.awt.*;

import javax.swing.*;
import java.util.ArrayList;

import com.afflorezc.controller.LocalPaths;
import com.afflorezc.controller.TextAnimationPause;
import com.afflorezc.model.VehicleInformation;
import com.afflorezc.controller.AudioPlayer;
import com.afflorezc.view.components.ImageContainer;

public class ChapterOne extends javax.swing.JFrame {

    int xMouse, yMouse;

    TextAnimationPause textAnimation;
    ArrayList<VehicleInformation> motorcicles;
    
    private static final String MONITOR_THREAD = "1";
    private static final String STORY_SOUND_PATH = LocalPaths.AUDIO_PATH + "chapterOne.m4a";

    private AudioPlayer storyAudio;

    final String storyText = "En una fría tarde de otoño, el equipo de físicos y amigos, Sheldon, Howard y"
                            + " Rajesh se preparan para una buena partida de calabozos y dragones, una vez que"
                            +" han dejado listo el montaje del nuevo experimento del CERN. Experimento que busca"
                            +" encontrar por fin el santo grial de la física: el gravitón. Tras varias votaciones"
                            +" eligieron la temática del inframundo y los demonios. Sheldon eligió como personaje"
                            +" a Dante, sin saber que las cosas se pondrían algo raras.";
                   
     private javax.swing.JPanel background;
     private javax.swing.JLabel backgroundImage;
     private javax.swing.JLabel exitBtn;
     private javax.swing.JLabel continueBtn;
     private javax.swing.JLabel startButton;
     private ImageContainer storyPanel;
     private javax.swing.JLabel storyLabel;
     private javax.swing.JLabel tittleLabel;
     private javax.swing.JPanel upperBar; 
    
    public ChapterOne(ArrayList<VehicleInformation> motorcicles) {
        
        initComponents();
        this.motorcicles = motorcicles;
        storyAudio = new AudioPlayer(STORY_SOUND_PATH, 0.70);
        int index = storyText.indexOf("ñ")+2;
        storyLabel.setText(storyText.substring(0, index) + "...");
        textAnimation = new TextAnimationPause(storyText, storyLabel, MONITOR_THREAD);
    }
                        
    private void initComponents() {

        background = new javax.swing.JPanel();
        upperBar = new javax.swing.JPanel();
        exitBtn = new javax.swing.JLabel();
        tittleLabel = new javax.swing.JLabel();
        storyPanel = new ImageContainer(LocalPaths.IMAGESPATH + "paper.jpg");
        storyLabel = new javax.swing.JLabel();
        continueBtn = new javax.swing.JLabel();
        startButton = new javax.swing.JLabel();
        backgroundImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setLocationRelativeTo(null);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setMaximumSize(new java.awt.Dimension(800, 600));
        background.setName("background"); 
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        upperBar.setBackground(new java.awt.Color(255, 255, 255));
        upperBar.setOpaque(false);
        upperBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                upperBarMouseDragged(evt);
            }
        });
        upperBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                upperBarMousePressed(evt);
            }
        });

        exitBtn.setFont(new java.awt.Font("High Tower Text", 0, 18)); // NOI18N
        exitBtn.setForeground(new java.awt.Color(255, 255, 255));
        exitBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitBtn.setText("X");
        exitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitBtnMouseExited(evt);
            }
        });

        javax.swing.GroupLayout upperBarLayout = new javax.swing.GroupLayout(upperBar);
        upperBar.setLayout(upperBarLayout);
        upperBarLayout.setHorizontalGroup(
            upperBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, upperBarLayout.createSequentialGroup()
                .addGap(0, 780, Short.MAX_VALUE)
                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        upperBarLayout.setVerticalGroup(
            upperBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, upperBarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        background.add(upperBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 30));

        tittleLabel.setFont(new java.awt.Font("High Tower Text", 0, 36)); // NOI18N
        tittleLabel.setForeground(new java.awt.Color(255, 255, 255));
        tittleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tittleLabel.setText("Capitulo uno: El juego");
        tittleLabel.setToolTipText("");
        background.add(tittleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 800, 40));

        storyPanel.setBackground(new java.awt.Color(255, 255, 255));
        storyPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        
        storyPanel.setOpaque(true);

        storyLabel.setFont(new java.awt.Font("High Tower Text", 0, 20));
        storyLabel.setForeground(new java.awt.Color(255, 255, 255));
        storyLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        storyLabel.setText("<html><p>En una fría tarde de otoño...</p></html>");
        storyLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        storyLabel.setAutoscrolls(true);
        storyLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout storyPanelLayout = new javax.swing.GroupLayout(storyPanel);
        storyPanel.setLayout(storyPanelLayout);
        storyPanelLayout.setHorizontalGroup(
            storyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(storyPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(storyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        storyPanelLayout.setVerticalGroup(
            storyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(storyPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(storyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        storyLabel.getAccessibleContext().setAccessibleName("story");
        storyLabel.getAccessibleContext().setAccessibleDescription("");

        background.add(storyPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 410, 380));

        continueBtn.setFont(new java.awt.Font("High Tower Text", 0, 18)); // NOI18N
        continueBtn.setForeground(new java.awt.Color(255, 255, 255));
        continueBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        continueBtn.setText("Continuar");
        continueBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        continueBtn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        continueBtn.setPreferredSize(new java.awt.Dimension(133, 26));
        continueBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                continueBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                continueBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                continueBtnMouseExited(evt);
            }
        });
        background.add(continueBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 500, 140, 40));

        startButton.setFont(new java.awt.Font("High Tower Text", 0, 18)); // NOI18N
        startButton.setForeground(new java.awt.Color(255, 255, 255));
        startButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        startButton.setText("Iniciar");
        startButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        startButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        startButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                startButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                startButtonMouseExited(evt);
            }
        });
        background.add(startButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 140, 40));

        backgroundImage.setIcon(new ImageIcon(LocalPaths.IMAGESPATH + "dice1.jpg")); 
        backgroundImage.setMaximumSize(new java.awt.Dimension(800, 600));
        backgroundImage.setMinimumSize(new java.awt.Dimension(800, 600));
        backgroundImage.setPreferredSize(new java.awt.Dimension(800, 600));
        background.add(backgroundImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                               

    private void exitBtnMouseClicked(java.awt.event.MouseEvent evt) {                                     

        System.exit(0);
    }                                    

    private void exitBtnMouseEntered(java.awt.event.MouseEvent evt) {                                     
        this.exitBtn.setForeground(Color.red);
    }                                    

    private void exitBtnMouseExited(java.awt.event.MouseEvent evt) {                                    
        this.exitBtn.setForeground(Color.white);
    }                                   

    private void upperBarMouseDragged(java.awt.event.MouseEvent evt) {                                      

        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xMouse, y-yMouse);
    }                                     

    private void upperBarMousePressed(java.awt.event.MouseEvent evt) {                                      

        xMouse = evt.getX();
        yMouse = evt.getY();
    }                                     

    private void continueBtnMouseClicked(java.awt.event.MouseEvent evt) {                                         
        if(!this.textAnimation.isAlive()){
            new ChapterTwo(this.motorcicles).setVisible(true);
            this.dispose();
        }
    }                                        

    private void continueBtnMouseEntered(java.awt.event.MouseEvent evt) {                                         
        this.continueBtn.setBackground(Color.red);
        this.continueBtn.setForeground(Color.gray);
        if(!this.continueBtn.isOpaque()){
            this.continueBtn.setOpaque(true);
        }
    }                                        

    private void continueBtnMouseExited(java.awt.event.MouseEvent evt) {                                        
        this.continueBtn.setBackground(Color.white);
        this.continueBtn.setForeground(Color.white);
        if(this.continueBtn.isOpaque()){
            this.continueBtn.setOpaque(false);
        }
    }                                       

    private void startButtonMouseClicked(java.awt.event.MouseEvent evt) {                                         
        storyAudio.play();
        textAnimation.start();
    }                                        

    private void startButtonMouseEntered(java.awt.event.MouseEvent evt) {                                         
        this.startButton.setBackground(Color.red);
        this.startButton.setForeground(Color.gray);
        if(!this.startButton.isOpaque()){
            this.startButton.setOpaque(true);
        }
    }                                        

    private void startButtonMouseExited(java.awt.event.MouseEvent evt) {                                        
        this.startButton.setBackground(Color.white);
        this.startButton.setForeground(Color.white);
        if(this.startButton.isOpaque()){
            this.startButton.setOpaque(false);
        }
    }                                                     
}
