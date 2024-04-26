package com.afflorezc.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.*;

import com.afflorezc.model.VehicleInformation;

public class ItemsReader {

    public ArrayList<String> readColumnNames(String path, String sheetName){

        ArrayList<String> columnNames = new ArrayList<String>();

        try(FileInputStream file = new FileInputStream(path)){
            Workbook book = WorkbookFactory.create(file);
            Sheet sheet = book.getSheet(sheetName);
            if(sheet.getLastRowNum()==0) 
                return columnNames;
            for(Cell cell: sheet.getRow(0)){
                columnNames.add(cell.getStringCellValue());
            }
        } catch(IOException ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return columnNames;
    }

    public ArrayList<VehicleInformation> readExcelFile(String path, String sheetName, int[] columnIndexes, 
                                    ArrayList<String> dataFilters){

        ArrayList<VehicleInformation> motorcicleData = new ArrayList<VehicleInformation>();
        try (FileInputStream file = new FileInputStream(path)) {
            
            Workbook book = WorkbookFactory.create(file);
            Sheet sheet = book.getSheet(sheetName);
            int totalColumns = columnIndexes.length;
            String tradeMark =  dataFilters.get(0); 
            
            for (Row row : sheet) {
                if(row.getRowNum()==0){
                    continue;
                }
                String description = dataFilters.get(2) + " ";
                int currentIndex = 0;
                int matches = 0;
                float price =0.0f;
                int power = 0;
                int cylinderCapacity = 0;
                for (Cell cell : row) {
                    if(currentIndex > totalColumns-1){
                        if(power > 150){
                            motorcicleData.add(new VehicleInformation(tradeMark, 
                                                        description, price, power, cylinderCapacity));
                        }
                        break;
                    }
                    if(cell.getColumnIndex() == columnIndexes[currentIndex]){
                        String text = cell.getStringCellValue();
                        if(matches >=3){
                            if(matches == 3){
                                System.out.print(dataFilters.get(0) + "\t");
                                System.out.print(dataFilters.get(2) + "\t");
                            }
                            switch (currentIndex) {
                                case 3 -> description += text;
                                case 4 -> price = Float.parseFloat(text);
                                case 5 -> power = Integer.parseInt(text);
                                case 6 -> cylinderCapacity = Integer.parseInt(text);
                            }
                            System.out.print(text + "\t");
                            matches++;
                            if(currentIndex >= totalColumns-1){
                                System.out.println();
                            }
                        }
                        if(dataFilters.contains(text)){
                            matches++;
                        }
                        currentIndex++;
                    }            
                }
                
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return motorcicleData;
    }

}
