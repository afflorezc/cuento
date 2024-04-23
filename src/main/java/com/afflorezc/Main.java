package com.afflorezc;

import java.util.ArrayList;
import java.util.Arrays;

import com.afflorezc.model.ItemsReader;

public class Main {

    static final String[] DATA_SET_NAMES = {"Marca","Clase", "Referencia1", "Referencia2", "Bcpp",
                                             "Potencia", "Cilindraje"};

    static final ArrayList<String> DATA_SET_FILTER = new ArrayList<String>(
                                                   Arrays.asList("KAWASAKI", "MOTOCICLETA", "NINJA"));
    static final String PATH = "cuento\\cuento2\\files\\Guia_Excel_331.xls";
    static final String SHEET_NAME = "Codigos";
    public static void main(String[] args) {

        System.out.println("Voy a leer mi archivo de excel");
        ItemsReader reader = new ItemsReader();
        ArrayList<String> columnNames = reader.readColumnNames(PATH, SHEET_NAME);
        int[] columnIndexes = getColumnIndexes(columnNames);
        reader.readExcelFile(PATH, SHEET_NAME, columnIndexes, DATA_SET_FILTER);
    }

    public static int[] getColumnIndexes(ArrayList<String> columnNames){

        int[] indexes = new int[6];
        int currentIndex = 0;
        int columnIndex = 0;
        for(String name: columnNames){
            if(currentIndex > 5){
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