package com.afflorezc.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.*;

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

    public void readExcelFile(String path, String sheetName, int[] columnIndexes, ArrayList<String> dataFilters){

        try (FileInputStream file = new FileInputStream(path)) {
            
            Workbook book = WorkbookFactory.create(file);
            Sheet sheet = book.getSheet(sheetName);
            int totalColumns = columnIndexes.length;
            for (Row row : sheet) {
                if(row.getRowNum()==0){
                    continue;
                }
                int currentIndex = 0;
                int matches = 0;
                for (Cell cell : row) {
                    if(currentIndex > totalColumns-1){
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
                                case 4 -> System.out.print("Price: ");
                                case 5 -> System.out.print("Power: ");
                                case 6 -> System.out.print("c.c: ");
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
    }


}
