package com.afflorezc.model;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;

public class CircuitDataReader {

    public int[][] readCircuitData(String path, String sheetName){

        int[][] circuitPoints;

        try (FileInputStream file = new FileInputStream(path)) {
            
            Workbook book = WorkbookFactory.create(file);
            Sheet sheet = book.getSheet(sheetName);
            int numOfPoints = sheet.getLastRowNum(); 
            circuitPoints = new int[numOfPoints][2];
            
            for (Row row : sheet) {
                int rowNumber = row.getRowNum()-1;
                if(rowNumber == -1){
                    continue;
                }
                for(Cell cell : row){
                    if(cell.getColumnIndex() == 1){
                        circuitPoints[rowNumber][0] = (int) cell.getNumericCellValue();
                    }
                    else if(cell.getColumnIndex() == 2){
                        circuitPoints[rowNumber][1] = (int) cell.getNumericCellValue();
                    }

                }
            }
            System.out.println("Lectura de datos del circuito exitosa!");
            return circuitPoints;   
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            return new int[0][0];
        }

    }
}
