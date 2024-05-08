package com.afflorezc.view.components;

import javax.swing.*;
import java.awt.*;

// Canvas draw the circuit and cars on circuit
public class Circuit extends JPanel{
	
	private static final int PADDING = 10;
    private static final float TRACK_OPACITY = 0.30f;
    private static final float CAR_OPACITY = 1.0f;
	private static final int SIZE_CAR = 6;
	private static final int TRACK_WIDTH = 8;
	public static final double PI = Math.PI;
	public static final int STEP = 1;
	private static final Color TRACK_COLOR = Color.gray.brighter();
    private int[][] circuitPoints;
	
	public Pilot[] pilots;
	
	public Circuit(int width, int height, int[][] circuitPoints){
		
		this.setSize(width, height);
		this.setLocation(0, 0);
		this.setBackground(new Color(255, 255, 255));
		this.setOpaque(false);
        // Set circuit data points
        this.circuitPoints = circuitPoints;
		// Set pilots
		this.pilots = new Pilot[3];
		pilots[0] = new Pilot("Howard", 5, Color.red.darker());
		pilots[1] = new Pilot("Dante", 10, Color.blue.brighter());
		pilots[2] = new Pilot("Sheldon", 7, Color.cyan.darker());
		// Set initial positions for cars
		int[] pos = this.getPosition(0);
		for(int i=0;i<3;i++) {
			pilots[i].currentPos = pos;
		}
	}
	
	@Override
	public void paintComponent(Graphics graph) {
		
		super.paintComponent(graph);
		// draws the circuit
		Graphics2D graph2 = (Graphics2D) graph;
		graph2.setStroke(new BasicStroke(TRACK_WIDTH));
		graph2.setColor(TRACK_COLOR);
        graph2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, TRACK_OPACITY));
		int lines = circuitPoints.length;
		
		for(int i=1;i<=lines;i++) {
			
			int[] sPoint = getPosition((i-1)*STEP);
			int[] ePoint = getPosition(i*STEP);
			
			graph2.drawLine(sPoint[0], sPoint[1], ePoint[0], ePoint[1]);
		}
		// draw the cars
		this.paintCars(graph);
	}
	
	public void paintCars(Graphics graph) {
		
        Graphics2D graph2 = (Graphics2D) graph;
        graph2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, CAR_OPACITY));
        for(Pilot pilot : this.pilots){
            graph2.setColor(pilot.carColor);
            graph2.fillOval(pilot.currentPos[0], pilot.currentPos[1], SIZE_CAR, SIZE_CAR);
        }
		/*// first pilot
		graph.setColor(pilots[0].carColor);
		graph.fillOval(pilots[0].currentPos[0] -SIZE_CAR/2, 
						        pilots[0].currentPos[1] + SIZE_CAR/2, SIZE_CAR, SIZE_CAR);
		// second pilot
		graph.setColor(pilots[1].carColor);
		graph.fillOval(pilots[1].currentPos[0] -SIZE_CAR/2, 
								pilots[1].currentPos[1], SIZE_CAR, SIZE_CAR);
		// third pilot
		graph.setColor(pilots[2].carColor);
		graph.fillOval(pilots[2].currentPos[0] -SIZE_CAR/2, 
								pilots[2].currentPos[1] -SIZE_CAR/2, SIZE_CAR, SIZE_CAR);*/
	}
	
    
	/*public int[] getPosition(double t) {
		
		int[] pos = new int[2];
		double x = 180 + PADDING;
		double y = 200 + PADDING;
		double radius = 150;
		
		for(int i=1;i<=4;i++) {
			
			if(i==1) {
				x += radius*Math.cos(i*t);
				y += radius*Math.sin(i*t);
			} else {
				x += Math.pow(-1, i)*radius*Math.cos(i*t);
				y -= radius*Math.sin(i*t);
			}	
			radius = radius/2;
		}
		
		pos[0] = (int) x;
		pos[1] = (int) y;
		
		return pos;
	}*/

    public int[] getPosition(int t){

        t = t % circuitPoints.length;
        int pos[] = new int[2];
        pos[0] = circuitPoints[t][0];
        pos[1] = circuitPoints[t][1];
        return pos;
    }

    public int[][] getCircuitPoints() {
        return circuitPoints;
    }
	
}
