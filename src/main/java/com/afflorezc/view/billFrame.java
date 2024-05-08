/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.afflorezc.view;

import com.afflorezc.controller.Bill;
import com.afflorezc.controller.CircuitLoader;
import com.afflorezc.controller.ExcelLoader;
import com.afflorezc.controller.LocalPaths;
import com.afflorezc.controller.PDFBill;
import com.afflorezc.controller.PDFManagement;
import com.afflorezc.view.components.ImageContainer;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author thomy
 */
public class billFrame extends javax.swing.JFrame {

    /**
     * Creates new form billFrame
     */
    private Bill bill;

    public billFrame(Bill bill) {
        this.bill = bill;
        //setLocationRelativeTo(null);
        setLocation(300, 80);
        new CircuitLoader().execute();
        initComponents();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public billFrame() {
        this.bill = new Bill("","","","");

        setLocation(300, 80);
        initComponents();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new ImageContainer(LocalPaths.IMAGESPATH+"concesionario.jpg");
        closeButtonLabel = new javax.swing.JLabel();
        jPanel2 = new ImageContainer(LocalPaths.IMAGESPATH+"factura-ejemplo.jpeg");
        openPDFButton = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        createPDFButton = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nextFrameButton = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 233, 173));

        closeButtonLabel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        closeButtonLabel.setForeground(new java.awt.Color(255, 255, 255));
        closeButtonLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        closeButtonLabel.setText("X");
        closeButtonLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        closeButtonLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeButtonLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeButtonLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeButtonLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 352, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 375, Short.MAX_VALUE)
        );

        openPDFButton.setBackground(new java.awt.Color(169, 0, 42));
        openPDFButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        openPDFButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                openPDFButtonMousePressed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Abrir Factura");

        javax.swing.GroupLayout openPDFButtonLayout = new javax.swing.GroupLayout(openPDFButton);
        openPDFButton.setLayout(openPDFButtonLayout);
        openPDFButtonLayout.setHorizontalGroup(
            openPDFButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
        );
        openPDFButtonLayout.setVerticalGroup(
            openPDFButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        createPDFButton.setBackground(new java.awt.Color(169, 0, 42));
        createPDFButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        createPDFButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createPDFButtonMouseClicked(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Crear Factura");

        javax.swing.GroupLayout createPDFButtonLayout = new javax.swing.GroupLayout(createPDFButton);
        createPDFButton.setLayout(createPDFButtonLayout);
        createPDFButtonLayout.setHorizontalGroup(
            createPDFButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
        );
        createPDFButtonLayout.setVerticalGroup(
            createPDFButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        nextFrameButton.setBackground(new java.awt.Color(169, 0, 42));
        nextFrameButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nextFrameButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextFrameButtonMouseClicked(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Siguiente");

        javax.swing.GroupLayout nextFrameButtonLayout = new javax.swing.GroupLayout(nextFrameButton);
        nextFrameButton.setLayout(nextFrameButtonLayout);
        nextFrameButtonLayout.setHorizontalGroup(
            nextFrameButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
        );
        nextFrameButtonLayout.setVerticalGroup(
            nextFrameButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 773, Short.MAX_VALUE)
                .addComponent(closeButtonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(openPDFButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createPDFButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(107, 107, 107))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nextFrameButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(316, 316, 316))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(closeButtonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(createPDFButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(openPDFButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(242, 242, 242))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(nextFrameButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonLabelMouseClicked
     
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_closeButtonLabelMouseClicked

    private void closeButtonLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonLabelMouseEntered
   
        closeButtonLabel.setForeground(new Color(255, 0, 0));
    }//GEN-LAST:event_closeButtonLabelMouseEntered

    private void closeButtonLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonLabelMouseExited

        closeButtonLabel.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_closeButtonLabelMouseExited

    private void openPDFButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openPDFButtonMousePressed
     
        PDFBill.openPDFBill();
    }//GEN-LAST:event_openPDFButtonMousePressed

    private void createPDFButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createPDFButtonMouseClicked
       
        this.bill.calculateIVA();
        this.bill.calculateBasePrice();
        PDFBill.generatePDFBill(this.bill);
    }//GEN-LAST:event_createPDFButtonMouseClicked

    private void nextFrameButtonMouseClicked(java.awt.event.MouseEvent evt) {                                             
        
        while(CircuitLoader.getCircuitPoints() == null){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } 
        new Race2(CircuitLoader.getCircuitPoints()).setVisible(true);
        this.dispose(); 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel closeButtonLabel;
    private javax.swing.JPanel createPDFButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel nextFrameButton;
    private javax.swing.JPanel openPDFButton;
    // End of variables declaration//GEN-END:variables
}
