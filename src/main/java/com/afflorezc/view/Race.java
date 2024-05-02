package com.afflorezc.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.afflorezc.view.components.*;
import com.afflorezc.controller.AnimationRace;

public class Race extends JFrame{
	
	static final int GUI_WIDTH = 1200;
	static final int GUI_HEIGHT = 700;
	static final int PADDING = 20;
	private int[][] circuitPoints;

	private ComponentsBuilder builder;
	
	private JPanel ppalPanel;
	private Circuit circuitTrack;
	private JPanel infoPanel;
	private JButton raceButton;
	private JButton nextButton;
	
	public Race(int[][] circuitPoints) {
		super("La gran carrera");
		Styles styles = getStyles();
		this.circuitPoints = circuitPoints;
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
		circuitTrack = new Circuit(500,360,circuitPoints);
	
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
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
    
    public static Styles getStyles(){
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
        return styles;
    }
	
}

// Listener: simulates the race
class RunRace implements ActionListener{
	
	AnimationRace simulation;
	
	RunRace(Circuit circuitTrack, JPanel tablePanel){
		this.simulation = new AnimationRace(circuitTrack, tablePanel);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// runs the simulation
		this.simulation.start();
	}
}