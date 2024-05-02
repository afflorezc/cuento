package com.afflorezc.controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.afflorezc.view.components.Circuit;
import com.afflorezc.view.components.Pilot;

public class AnimationRace extends Thread{
	
	Circuit circuitTrack;
	JLabel lapLabel;
	JTable raceTable;
	JTable resultsTable;
	private static final int LAPS = 5;
	private static final int FRAME_DURATION = 120;
	private int lapCount;
	
	public AnimationRace(Circuit circuitTrack, JPanel tablePanel){
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

	public void pause(){
		try {
			Thread.currentThread().wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		
		while(lapCount < LAPS) {
			// Update the positions for pilots
			int minT = (int) 1.5*LAPS*circuitTrack.getCircuitPoints().length;
			int maxT = 0;
			for(int i=0; i<circuitTrack.pilots.length;i++) {
				int t = (int) Math.floor(Math.random()*(2)+1);
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
            boolean first = false;
            boolean third = false;
			// Updates the racePositions
			for(int i=0; i<circuitTrack.pilots.length;i++) {
				
                
				int t = circuitTrack.pilots[i].tParameter;
				if(t == minT && !third) {
					circuitTrack.pilots[i].racePos = 3;
                    third = true;
				} else if(t == maxT && !first) {
					circuitTrack.pilots[i].racePos = 1;
                    first = true;
				} else {
					circuitTrack.pilots[i].racePos = 2;
				}
			}
			this.setPositions();
			// get the current Lap
			this.lapCount = (int) (minT /circuitTrack.getCircuitPoints().length);
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
		JOptionPane.showMessageDialog(null, "Fin de la carrera!!");
		this.setFinalResult();
	}
}
