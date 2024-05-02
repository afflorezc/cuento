package com.afflorezc.view;

import java.awt.*;

import javax.swing.*;

import com.afflorezc.controller.AnimationRace;
import com.afflorezc.controller.CircuitLoader;
import com.afflorezc.controller.LocalPaths;
import com.afflorezc.view.components.Circuit;


/**
 *
 * @author admiin
 */
public class Race2 extends javax.swing.JFrame {

    int xMouse, yMouse;
    private int[][] circuitPoints;

    
    // Variables declaration                     
    private JPanel background;
    private JLabel backgroundImage;
    private JLabel circuitImage;
    private Circuit circuitPanel;
    private JLabel exitBtn;
    private JLabel nextButton;
    private javax.swing.JLabel startButton;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JLabel tittleLabel;
    private javax.swing.JPanel upperBar;
    // End of variables declaration     
    
    public Race2(int[][] circuitPoints) {
        
        this.circuitPoints = circuitPoints;
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {

        background = new javax.swing.JPanel();
        upperBar = new javax.swing.JPanel();
        exitBtn = new javax.swing.JLabel();
        tittleLabel = new javax.swing.JLabel();
        tablePanel = new javax.swing.JPanel();
        JLabel lapLabel = new JLabel();
        lapLabel.setForeground(Color.white);
        lapLabel.setText("Vuelta actual:");
        lapLabel.setFont(new Font("High Tower Text", 0, 20));
        JLabel finalResultLabel = new JLabel();
        finalResultLabel.setForeground(Color.white);
        finalResultLabel.setFont(new Font("High Tower Text", 0, 20));
        JTable finalResultsTable = new JTable();
        JTable resultsTable = new javax.swing.JTable();
        circuitPanel = new Circuit(500, 360, circuitPoints);
        circuitImage = new javax.swing.JLabel();
        nextButton = new javax.swing.JLabel();
        startButton = new javax.swing.JLabel();
        backgroundImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setMaximumSize(new java.awt.Dimension(800, 600));
        background.setName("background"); // NOI18N
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
        tittleLabel.setForeground(Color.black);
        tittleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tittleLabel.setText("La gran carrera");
        background.add(tittleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 800, 40));

        tablePanel.setOpaque(false);

        resultsTable.setFont(new java.awt.Font("High Tower Text", 0, 18)); // NOI18N
        resultsTable.setForeground(new java.awt.Color(138,43,43));
        resultsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
            },
            new String [] {
                "Corredor", "Posición"
            }
        ));
        resultsTable.setAutoscrolls(false);
        resultsTable.setOpaque(false);

        finalResultsTable.setFont(new java.awt.Font("High Tower Text", 0, 18)); // NOI18N
        finalResultsTable.setForeground(new java.awt.Color(138,43,43));
        finalResultsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
            },
            new String [] {
                "Corredor", "Posición"
            }
        ));

        finalResultsTable.setAutoscrolls(false);
        finalResultsTable.setOpaque(false);

        GridLayout tablesLayout = new GridLayout(4, 1);
		tablePanel.setLayout(tablesLayout);

        tablePanel.add(lapLabel);
		tablePanel.add(resultsTable);
		tablePanel.add(finalResultLabel);
		tablePanel.add(finalResultsTable);

        background.add(tablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, 220, 300));

        circuitImage.setIcon(new ImageIcon(LocalPaths.IMAGESPATH+"circuito.png"));
        circuitImage.setOpaque(false);

        javax.swing.GroupLayout circuitPanelLayout = new javax.swing.GroupLayout(circuitImage);
        circuitImage.setLayout(circuitPanelLayout);
        circuitPanelLayout.setHorizontalGroup(
            circuitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(circuitPanelLayout.createSequentialGroup()
                .addComponent(circuitPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        circuitPanelLayout.setVerticalGroup(
            circuitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(circuitPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
        );

        background.add(circuitImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 500, 360));

        nextButton.setBackground(new java.awt.Color(138, 43, 43));
        nextButton.setFont(new java.awt.Font("High Tower Text", 0, 18)); // NOI18N
        nextButton.setForeground(new java.awt.Color(255, 255, 255));
        nextButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nextButton.setText("Siguiente");
        nextButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        nextButton.setOpaque(true);
        nextButton.setPreferredSize(new java.awt.Dimension(133, 26));
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
        background.add(nextButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 520, 140, 40));

        startButton.setBackground(new java.awt.Color(138, 43, 43));
        startButton.setFont(new java.awt.Font("High Tower Text", 0, 18)); // NOI18N
        startButton.setForeground(new java.awt.Color(255, 255, 255));
        startButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        startButton.setText("Iniciar carrera");
        startButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        startButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        startButton.setOpaque(true);
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
        background.add(startButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 440, 140, 40));

        backgroundImage.setIcon(new ImageIcon(LocalPaths.IMAGESPATH+"fondo_monaco.jpg")); 
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

    private void nextButtonMouseClicked(java.awt.event.MouseEvent evt) {                                        
        
    }                                       

    private void nextButtonMouseEntered(java.awt.event.MouseEvent evt) {                                        
        this.nextButton.setBackground(Color.red);
        this.nextButton.setForeground(Color.gray);
    }                                       

    private void nextButtonMouseExited(java.awt.event.MouseEvent evt) {                                       
        this.nextButton.setBackground(new Color(138,43,43));
        this.nextButton.setForeground(Color.white);
    }                                      

    private void startButtonMouseClicked(java.awt.event.MouseEvent evt) {                                         
        AnimationRace simulation = new AnimationRace(circuitPanel, tablePanel);
		simulation.start();
    }                                        

    private void startButtonMouseEntered(java.awt.event.MouseEvent evt) {                                         
        this.startButton.setBackground(Color.red);
        this.startButton.setForeground(Color.gray);
    }                                        

    private void startButtonMouseExited(java.awt.event.MouseEvent evt) {                                        
        this.startButton.setBackground(new Color(138,43,43));
        this.startButton.setForeground(Color.white);
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
            java.util.logging.Logger.getLogger(Race.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Race.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Race.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Race.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CircuitLoader().execute();
                while(CircuitLoader.getCircuitPoints() == null){
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } 
                new Race2(CircuitLoader.getCircuitPoints()).setVisible(true);
            }
        });
    }              
}
