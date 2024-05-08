package com.afflorezc.controller;

import javax.swing.SwingWorker;

import com.afflorezc.model.CircuitDataReader;

public class CircuitLoader extends SwingWorker<Void, Void> {

    static final String PATH = LocalPaths.EXCELPATH+"circuit.xlsx";
    static final String SHEET_NAME = "Hoja1";
    private static int[][] circuitPoints;

     @Override
    protected Void doInBackground() throws Exception{

         try{
            Thread.sleep(100);
            System.out.println("Leyendo datos circuito");
            CircuitDataReader reader = new CircuitDataReader();
            circuitPoints = reader.readCircuitData(PATH, SHEET_NAME);

        } catch(InterruptedException e){
            e.printStackTrace();
        }
        return null;
    }

    public static int[][] getCircuitPoints() {
        return circuitPoints;
    }

}
