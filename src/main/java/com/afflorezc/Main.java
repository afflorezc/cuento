package com.afflorezc;

import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;

import com.afflorezc.model.*;
import com.afflorezc.view.MotoSelection;

public class Main {

    static final String[] DATA_SET_NAMES = {"Marca","Clase", "Referencia1", "Referencia2", "Bcpp",
                                             "Potencia", "Cilindraje"};

    static final ArrayList<String> DATA_SET_FILTER = new ArrayList<String>(
                                                   Arrays.asList("KAWASAKI", "MOTOCICLETA", "NINJA"));
    static final String PATH = "files\\Guia_Excel_331.xls";
    static final String SHEET_NAME = "Codigos";
    public static void main(String[] args) {
        
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
        ArrayList<VehicleInformation> motoInfo = readExcelData();
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MotoSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MotoSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MotoSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MotoSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MotoSelection(motoInfo).setVisible(true);
            }
        });
    }

    public static int[] getColumnIndexes(ArrayList<String> columnNames){

        int numColumns = DATA_SET_NAMES.length;
        int[] indexes = new int[numColumns];
        int currentIndex = 0;
        int columnIndex = 0;
        for(String name: columnNames){
            if(currentIndex > numColumns-1){
                break;
            }
            if(name.equals(DATA_SET_NAMES[currentIndex])){
                indexes[currentIndex] = columnIndex;
                currentIndex++;
            }
            columnIndex++;
        }
        return indexes;
    }

    public static ArrayList<VehicleInformation> readExcelData(){

        System.out.println("Voy a leer mi archivo de excel ");
        ItemsReader reader = new ItemsReader();
        ArrayList<String> columnNames = reader.readColumnNames(PATH, SHEET_NAME);
        int[] columnIndexes = getColumnIndexes(columnNames);
        ArrayList<VehicleInformation> motoInfo = reader.readExcelFile(PATH, SHEET_NAME, columnIndexes, 
                                                                         DATA_SET_FILTER);
        return motoInfo;
    }
}