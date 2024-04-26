package com.afflorezc.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.afflorezc.view.components.*;

public class Race extends JFrame{
	
	static final int GUI_WIDTH = 800;
	static final int GUI_HEIGHT = 500;
	static final int PADDING = 20;

	private ComponentsBuilder builder;
	
	private JPanel ppalPanel;
	private Circuit circuitTrack;
	private JPanel infoPanel;
	private JButton raceButton;
	private JButton nextButton;
	
	public Race(Styles styles) {
		 
		super("La gran carrera");
		// Builder
		builder = new ComponentsBuilder(styles);
		// Main container
		ppalPanel = builder.buildJPanel();
		this.setContentPane(ppalPanel);
		//ppalPanel = getContentPane();
		//ppalPanel.setBackground(new Color(255, 233, 173));
		GridLayout ppalLayout = new GridLayout();
		ppalLayout.setHgap(PADDING);
		ppalLayout.setVgap(PADDING);
		ppalPanel.setLayout(ppalLayout);
		
		// Circuit track
		circuitTrack = new Circuit();
	
		// Results Panel
		infoPanel = builder.buildJPanel();
		//infoPanel = new JPanel();
		GridLayout infoLayout = new GridLayout(2, 1);
		infoLayout.setVgap(PADDING);
		infoPanel.setLayout(infoLayout);
		
		// Panel for tables and other label info
		JPanel tablePanel = builder.buildJPanel();
		// JPanel tablePanel = new JPanel();
		GridLayout tablesLayout = new GridLayout(4, 1);
		tablePanel.setLayout(tablesLayout);
		//tablePanel.setBackground(new Color(255, 233, 173));
		// Label for the lap race
		JLabel lapLabel = builder.buildJLabel(false);
		//JLabel lapLabel = new JLabel();
		//lapLabel.setFont(new Font("DejaVu Sans", Font.PLAIN, 14));
		//lapLabel.setText("Current Lap: ");
		// Label for the final result
		JLabel finalResultLabel = builder.buildJLabel(false);
		//JLabel finalResultLabel = new JLabel();
		//finalResultLabel.setFont(new Font("DejaVu Sans", Font.PLAIN, 14));
		//finalResultLabel.setText("Final Results: ");
		// Results Table
		JTable positionInfo = new JTable(new DefaultTableModel());
		positionInfo.setBackground(new Color(255, 233, 173));
		positionInfo.setShowHorizontalLines(true);
		positionInfo.setShowVerticalLines(true);
		// Final position Table
		JTable endResults = new JTable(new DefaultTableModel());
		endResults.setBackground(new Color(255, 233, 173));
		endResults.setShowHorizontalLines(true);
		endResults.setShowVerticalLines(true);
		tablePanel.add(lapLabel);
		tablePanel.add(positionInfo);
		tablePanel.add(finalResultLabel);
		tablePanel.add(endResults);
		// Panel for the button
		JPanel panelButton = builder.buildJPanel();
		panelButton.setLayout(new BoxLayout(panelButton, BoxLayout.Y_AXIS));
		//JPanel panelButton = new JPanel();
		//panelButton.setBackground(new Color(255, 233, 173));
		// Simulate the race: Button
		raceButton = builder.buildButton("Start race");
		//raceButton = new JButton("Start race");
		raceButton.addActionListener(new RunRace(circuitTrack, tablePanel));
		//raceButton.setSize(60, 40);
        //raceButton.setBackground(new Color(169, 0, 0));
        //raceButton.setForeground(new Color(169,255,255));
        //raceButton.setFocusPainted(false);
		// Next button: 
		nextButton = builder.buildButton("Next");
		//nextButton = new JButton("Siguiente");
		//nextButton.addActionListener(new RunRace(circuitTrack, tablePanel));
		//nextButton.setSize(60, 40);
        //nextButton.setBackground(new Color(169, 0, 0));
        //nextButton.setForeground(new Color(169,255,255));
        //nextButton.setFocusPainted(false);
		panelButton.add(raceButton);
		panelButton.add(nextButton);
		// Adding components to info Panel
		//infoPanel.setBackground(new Color(255, 233, 173));
		infoPanel.add(tablePanel);
		infoPanel.add(panelButton);
		// Adding components to main container
		ppalPanel.add(circuitTrack);
		ppalPanel.add(infoPanel);
		this.setSize(GUI_WIDTH + 2*PADDING, GUI_HEIGHT + 2*PADDING);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

    public static void main(String[] args){

		Color backGround = new Color(255, 233, 173);
		Color foreGround = new Color(169,255,255);
		Color buttonBackGround = new Color(169, 0, 0);
		Color buttonForeGround = new Color(169,255,255);
		Font titlesFont = new Font("DejaVu Sans", Font.PLAIN, 20);
		Font contentFont = new Font("DejaVu Sans", Font.PLAIN, 14);
		Font buttonFont = new Font("DejaVu Sans", Font.PLAIN, 14);
		int padding = 20;
		Styles styles = new Styles(backGround, foreGround, buttonBackGround, buttonForeGround,
		                               titlesFont, contentFont, buttonFont, padding);
        new Race(styles);
    }
	
}

// Listener: simulates the race
class RunRace implements ActionListener{
	
	animationRace simulation;
	
	RunRace(Circuit circuitTrack, JPanel tablePanel){
		this.simulation = new animationRace(circuitTrack, tablePanel);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// runs the simulation
		this.simulation.start();
	}
}

class animationRace extends Thread{
	
	Circuit circuitTrack;
	JLabel lapLabel;
	JTable raceTable;
	JTable resultsTable;
	private static final int LAPS = 5;
	private static final int FRAME_DURATION = 50;
	private int lapCount;
	
	animationRace(Circuit circuitTrack, JPanel tablePanel){
		this.circuitTrack = circuitTrack;
		this.lapCount = 0;
		this.lapLabel = (JLabel) tablePanel.getComponent(0);
		this.raceTable = (JTable) tablePanel.getComponent(1);
		this.resultsTable = (JTable) tablePanel.getComponent(3);
	}
	
	public void setPositions() {
		
		String[] columns = new String[] {"Position", "Name"};
		DefaultTableModel dataModel = new DefaultTableModel();
		dataModel.setColumnIdentifiers(columns);
		dataModel.addRow(columns);
		int cont = 1;
		boolean isCompleted = false;
		while(!isCompleted) {
			for(Pilot pilot:circuitTrack.pilots) {
				if(pilot.racePos == cont) {
					String[] data = new String[2];
					data[0] = Integer.toString(cont);
					data[1] = pilot.name;
					dataModel.addRow(data);
					cont++;
				}
			}
			if(cont > circuitTrack.pilots.length) {
				isCompleted = true;
			}
		}
		raceTable.setModel(dataModel);
	}

public void setFinalPoints() {
	
	int maxPoints = 0;
	int minPoints = 25;
	for(Pilot pilot:circuitTrack.pilots) {
		pilot.setFinalPoints();
		if(pilot.points < minPoints) {
			minPoints = pilot.points;
		} else if(pilot.points > maxPoints) {
			maxPoints = pilot.points;
		}
	}
	
	setFinalPositions(minPoints, maxPoints);
}

public void setFinalPositions(int minPoints, int maxPoints) {
	
	for(Pilot pilot:circuitTrack.pilots) {
		if(pilot.points == minPoints) {
			pilot.finalPos = 3;
		} else if(pilot.points == maxPoints) {
			pilot.finalPos = 1;
		} else {
			pilot.finalPos = 2;
		}
	}
}
	
public void setFinalResult() {
		
		String[] columns = new String[] {"Position", "Name", "Total Points"};
		DefaultTableModel dataModel = new DefaultTableModel();
		dataModel.setColumnIdentifiers(columns);
		dataModel.addRow(columns);
		// Get the final points and final position for each pilot
		this.setFinalPoints();
		
		int cont = 1;
		boolean isCompleted = false;
		while(!isCompleted) {
			for(Pilot pilot:circuitTrack.pilots) {
				if(pilot.finalPos == cont) {
					String[] data = new String[3];
					data[0] = Integer.toString(cont);
					data[1] = pilot.name;
					data[2] = Integer.toString(pilot.points);
					dataModel.addRow(data);
					cont++;
				}
			}
			if(cont > circuitTrack.pilots.length) {
				isCompleted = true;
			}
		}
		
		resultsTable.setModel(dataModel);
	}
	
	@Override
	public void run() {
		
		while(lapCount < LAPS) {
			// Update the positions for pilots
			double minT = 1.5*LAPS*2*Math.PI;
			double maxT = 0;
			for(int i=0; i<circuitTrack.pilots.length;i++) {
				double t = Math.random()*Circuit.STEP;
				t += circuitTrack.pilots[i].tParameter;
				circuitTrack.pilots[i].tParameter = t;
				if(t < minT) {
					minT = t;
				}
				if(t > maxT) {
					maxT = t;
				}
				//t = t%(2*Math.PI);
				circuitTrack.pilots[i].currentPos = circuitTrack.getPosition(t);
			}
			circuitTrack.repaint();
			// Updates the racePositions
			for(int i=0; i<circuitTrack.pilots.length;i++) {
				
				double t = circuitTrack.pilots[i].tParameter;
				if(t == minT) {
					circuitTrack.pilots[i].racePos = 3;
				} else if(t == maxT) {
					circuitTrack.pilots[i].racePos = 1;
				} else {
					circuitTrack.pilots[i].racePos = 2;
				}
			}
			this.setPositions();
			// get the current Lap
			this.lapCount = (int) (minT /(2*Math.PI));
			if(this.lapCount+1 >= LAPS) {
				lapLabel.setText("Current Lap: Final Lap");
			}else {
				lapLabel.setText("Current Lap: " + (lapCount+1));
			}
			// waits for next frame
			try {
				Thread.sleep(FRAME_DURATION);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		JOptionPane.showMessageDialog(null, "End of the race!!");
		this.setFinalResult();
	}
}
// Canvas draw the circuit and cars on circuit
class Circuit extends JPanel{
	
	private static final int WIDTH = 400;
	private static final int HEIGHT = 400;
	private static final int PADDING = 10;
	private static final int SIZE_CAR = 8;
	private static final int TRACK_WIDTH = 12;
	public static final double PI = Math.PI;
	public static final double STEP = PI/36;
	private static final Color TRACK_COLOR = Color.gray.brighter();
	
	Pilot[] pilots;
	
	Circuit(){
		
		this.setSize(WIDTH + 2*PADDING, HEIGHT +2*PADDING);
		this.setLocation(PADDING, PADDING);
		this.setBackground(new Color(255, 233, 173));
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
		int lines = (int) (2*PI/STEP);
		
		for(int i=1;i<=lines;i++) {
			
			int[] sPoint = getPosition((i-1)*STEP);
			int[] ePoint = getPosition(i*STEP);
			
			graph2.drawLine(sPoint[0], sPoint[1], ePoint[0], ePoint[1]);
		}
		// draw the cars
		this.paintCars(graph);
	}
	
	public void paintCars(Graphics graph) {
		
		// first pilot
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
								pilots[2].currentPos[1] -SIZE_CAR/2, SIZE_CAR, SIZE_CAR);
	}
	
	public int[] getPosition(double t) {
		
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
	}
	
}

// cars and Pilot information
class Pilot {
	
	String name;
	int points;
	int[] currentPos = new int[2];
	int racePos;
	int finalPos;
	double tParameter;
	Color carColor;
	
	Pilot() {
		
	}
	
	Pilot(String name, int points, Color carColor){
		this.name = name;
		this.points = points;
		this.carColor = carColor;
		this.tParameter = 0;
	}	
	
	public void setFinalPoints() {
		
		switch(racePos) {
			case 1 -> this.points += 10;
			case 2 -> this.points += 6;
			case 3 -> this.points += 4;
		}
	}
	
}