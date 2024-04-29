package com.afflorezc;

import com.afflorezc.view.Player;

public class Main {

     /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Player().setVisible(true);
            }
        });
    }    
        /*
        Color backGround = new Color(255,254,224);
		Color foreGround = new Color(138,43,43);
		Color buttonBackGround = new Color(169, 0, 0);
		Color buttonForeGround = new Color(169,255,255);
		Font titlesFont = new Font("DejaVu Sans", Font.PLAIN, 20);
		Font contentFont = new Font("DejaVu Sans", Font.PLAIN, 14);
		Font buttonFont = new Font("DejaVu Sans", Font.PLAIN, 14);
		int padding = 20;
		Styles styles = new Styles(backGround, foreGround, buttonBackGround, buttonForeGround,
		                               titlesFont, contentFont, buttonFont, padding);

        new SelectMotorcicle(motoInfo, styles); */
}