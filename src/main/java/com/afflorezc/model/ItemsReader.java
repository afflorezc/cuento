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
            for (Row row : sheet) {
                if(row.getRowNum()==0){
                    continue;
                }
                int currentIndex = 0;
                int matches = 0;
                for (Cell cell : row) {
                    if(currentIndex > 5){
                        break;
                    }
                    if(cell.getColumnIndex() == columnIndexes[currentIndex]){
                        String text = cell.getStringCellValue();
                        if(matches >=3){
                            System.out.print(text + "\t");
                            if(currentIndex >= 5){
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
