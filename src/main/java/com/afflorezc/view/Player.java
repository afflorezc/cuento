package com.afflorezc.view;

import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import com.afflorezc.controller.LocalPaths;
import com.afflorezc.controller.ExcelLoader;

public class Player extends javax.swing.JFrame {

    int xMouse, yMouse;

     // Variables declaration - do not modify                     
     private javax.swing.JPanel background;
     private javax.swing.JPanel videoPanel;
     private javax.swing.JLabel exitButton;
     private javax.swing.JPanel upperPanel;
     // End of variables declaration 
    
    private final JFXPanel jfxPanel = new JFXPanel();
    
    public Player() {

        initComponents();
        new ExcelLoader().execute();
        createScene();
        setLocationRelativeTo(null);
        videoPanel.setLayout(new BorderLayout());
        this.videoPanel.add(jfxPanel, BorderLayout.CENTER);
    }

    public void endVideo(){
        new Menu(ExcelLoader.getMotorcicleData()).setVisible(true);
        this.dispose();
    }
    
    private void createScene(){
        Platform.runLater(new Runnable() {
            
            @Override
            public void run(){
                File file = new File(LocalPaths.RELATIVEPATH + "files\\video\\SheldonDante.mp4");
                MediaPlayer video;
                try {
                    String urlFile = file.toURI().toURL().toString();
                    video = new MediaPlayer(new Media(urlFile));
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    return;
                }
                MediaView view = new MediaView(video);
                view.setFitHeight(600);
                view.setFitWidth(800);
                view.setPreserveRatio(false);
                jfxPanel.setScene(new Scene(new Group(view)));
                video.setVolume(0.7);
                video.setCycleCount(1);
                video.play();
                video.setOnEndOfMedia(new Runnable() {
                    @Override 
                    public void run(){
                        endVideo();
                    }
                });
            }
        });  
    }
                         
    private void initComponents() {

        background = new javax.swing.JPanel();
        upperPanel = new javax.swing.JPanel();
        exitButton = new javax.swing.JLabel();
        videoPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        background.setBackground(new java.awt.Color(255,254,224));
        background.setMaximumSize(new java.awt.Dimension(800, 600));
        background.setMinimumSize(new java.awt.Dimension(800, 600));
        background.setPreferredSize(new java.awt.Dimension(800, 600));
        videoPanel.setBackground(new Color(255,254,224));
        upperPanel.setOpaque(false);
        upperPanel.setPreferredSize(new Dimension(800,20));
        upperPanel.setMaximumSize(new Dimension(800, 20));
        upperPanel.setMinimumSize(new Dimension(800,20));
        upperPanel.setSize(getPreferredSize());
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

        exitButton.setBackground(new java.awt.Color(255,254,224));
        exitButton.setFont(new java.awt.Font("High Tower Text", 0, 18)); 
        exitButton.setForeground(new java.awt.Color(138, 43, 43));
        exitButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitButton.setText("X");
        exitButton.setSize(new Dimension(20,20));
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
            .addComponent(exitButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout videoPanelLayout = new javax.swing.GroupLayout(videoPanel);
        videoPanel.setLayout(videoPanelLayout);
        videoPanelLayout.setHorizontalGroup(
            videoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        videoPanelLayout.setVerticalGroup(
            videoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 564, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(upperPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(videoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(upperPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(videoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

    private void exitButtonMouseClicked(java.awt.event.MouseEvent evt) {                                        
        System.exit(0);
    }                                       

    private void exitButtonMouseEntered(java.awt.event.MouseEvent evt) {                                        
        this.exitButton.setForeground(Color.red);
    }                                       

    private void exitButtonMouseExited(java.awt.event.MouseEvent evt) {                                       
        this.exitButton.setForeground(new Color(138, 43, 43));
    }                                      

    private void upperPanelMouseDragged(java.awt.event.MouseEvent evt) {                                        

        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xMouse, y-yMouse);
    }                                       

    private void upperPanelMousePressed(java.awt.event.MouseEvent evt) {                                        
        xMouse = evt.getX();
        yMouse = evt.getY();
    }                                       

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Player().setVisible(true);
            }
        });
    }                  
}
