package com.afflorezc.controller;

import javax.swing.SwingWorker;
import java.util.ArrayList;
import java.util.Arrays;
import com.afflorezc.model.ItemsReader;
import com.afflorezc.model.VehicleInformation;

public class ExcelLoader extends SwingWorker<Void, Void> {

    static final String[] DATA_SET_NAMES = {"Marca","Clase", "Referencia1", "Referencia2", "Bcpp",
                                             "Potencia", "Cilindraje"};

    static final ArrayList<String> DATA_SET_FILTER = new ArrayList<String>(
                                                   Arrays.asList("KAWASAKI", "MOTOCICLETA", "NINJA"));
    static final String PATH = "files\\Guia_Excel_331.xls";
    static final String SHEET_NAME = "Codigos";
    private static ArrayList<VehicleInformation> motorcicleData;

    @Override
    protected Void doInBackground() throws Exception{

        try{
            Thread.sleep(100);
            System.out.println("Voy a leer mi archivo de excel");
            ItemsReader reader = new ItemsReader();
            ArrayList<String> columnNames = reader.readColumnNames(PATH, SHEET_NAME);
            int[] columnIndexes = getColumnIndexes(columnNames);
            motorcicleData = reader.readExcelFile(PATH, SHEET_NAME, columnIndexes, DATA_SET_FILTER);

        } catch(InterruptedException e){
            e.printStackTrace();
        }
        return null;
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

    public static ArrayList<VehicleInformation> getMotorcicleData() {
        return motorcicleData;
    }

}
