package com.afflorezc.view;

import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;

public class Menu extends javax.swing.JFrame {

    int xMouse, yMouse;
    
    // Variables declaration - do not modify                     
    private JPanel background;
    private JLabel backgroundImage;
    private JLabel exitBtn;
    private JLabel settingsBtn;
    private JLabel startButton;
    private JPanel upperBar;
    // End of variables declaration   

    public Menu() {
        initComponents();
    }
                        
    private void initComponents() {

        background = new javax.swing.JPanel();
        upperBar = new javax.swing.JPanel();
        exitBtn = new javax.swing.JLabel();
        settingsBtn = new javax.swing.JLabel();
        startButton = new javax.swing.JLabel();
        backgroundImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Facturación");
        setBackground(new java.awt.Color(255, 233, 173));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setUndecorated(true);
        setResizable(false);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setMaximumSize(new java.awt.Dimension(800, 600));
        background.setMinimumSize(new java.awt.Dimension(800, 600));
        background.setName("background"); // NOI18N
        background.setPreferredSize(new java.awt.Dimension(800, 600));
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

        settingsBtn.setFont(new java.awt.Font("High Tower Text", 0, 18)); // NOI18N
        settingsBtn.setForeground(new java.awt.Color(255, 255, 255));
        settingsBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        settingsBtn.setText("Configuración");
        settingsBtn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        settingsBtn.setPreferredSize(new java.awt.Dimension(133, 26));
        settingsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settingsBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingsBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingsBtnMouseExited(evt);
            }
        });
        background.add(settingsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 370, 140, 40));
        settingsBtn.getAccessibleContext().setAccessibleName("Configuracion");

        startButton.setFont(new java.awt.Font("High Tower Text", 0, 18)); // NOI18N
        startButton.setForeground(new java.awt.Color(255, 255, 255));
        startButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        startButton.setText("Iniciar aventura");
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
        background.add(startButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 140, 40));

        backgroundImage.setIcon(new ImageIcon("src\\main\\java\\com\\afflorezc\\view\\images\\sheldonCern.png")); 
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

    private void upperBarMousePressed(java.awt.event.MouseEvent evt) {                                      
        
        xMouse = evt.getX();
        yMouse = evt.getY();
    }                                     

    private void upperBarMouseDragged(java.awt.event.MouseEvent evt) {                                      
        
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xMouse, y-yMouse);
    }                                     

    private void exitBtnMouseClicked(java.awt.event.MouseEvent evt) {                                     
        
        System.exit(0);
    }                                    

    private void exitBtnMouseEntered(java.awt.event.MouseEvent evt) {                                     
        this.exitBtn.setForeground(Color.red);
    }                                    

    private void exitBtnMouseExited(java.awt.event.MouseEvent evt) {                                    
        // TODO add your handling code here:
        this.exitBtn.setForeground(Color.white);
    }                                   

    private void startButtonMouseClicked(java.awt.event.MouseEvent evt) {                                         
        
    }                                        

    private void startButtonMouseEntered(java.awt.event.MouseEvent evt) {                                         
       this.startButton.setBackground(new Color(169, 0, 0));
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

    private void settingsBtnMouseClicked(java.awt.event.MouseEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void settingsBtnMouseEntered(java.awt.event.MouseEvent evt) {                                         
        this.settingsBtn.setBackground(new Color(169, 0, 0));
       this.settingsBtn.setForeground(Color.gray);
       if(!this.settingsBtn.isOpaque()){
           this.settingsBtn.setOpaque(true);
       }
    }                                        

    private void settingsBtnMouseExited(java.awt.event.MouseEvent evt) {                                        
        this.settingsBtn.setBackground(Color.white);
        this.settingsBtn.setForeground(Color.white);
        if(this.settingsBtn.isOpaque()){
           this.settingsBtn.setOpaque(false);
       }
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }                
}
