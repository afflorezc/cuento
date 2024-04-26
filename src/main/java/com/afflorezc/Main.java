package com.afflorezc;

import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;

import com.afflorezc.model.*;
import com.afflorezc.view.SelectMotorcicle;
import com.afflorezc.view.components.Styles;

public class Main {

    static final String[] DATA_SET_NAMES = {"Marca","Clase", "Referencia1", "Referencia2", "Bcpp",
                                             "Potencia", "Cilindraje"};

    static final ArrayList<String> DATA_SET_FILTER = new ArrayList<String>(
                                                   Arrays.asList("KAWASAKI", "MOTOCICLETA", "NINJA"));
    static final String PATH = "files\\Guia_Excel_331.xls";
    static final String SHEET_NAME = "Codigos";
    public static void main(String[] args) {

        System.out.println("Voy a leer mi archivo de excel ");
        ItemsReader reader = new ItemsReader();
        ArrayList<String> columnNames = reader.readColumnNames(PATH, SHEET_NAME);
        int[] columnIndexes = getColumnIndexes(columnNames);
        ArrayList<VehicleInformation> motoInfo = reader.readExcelFile(PATH, SHEET_NAME, columnIndexes, DATA_SET_FILTER);
        
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

        new SelectMotorcicle(motoInfo, styles);
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
}