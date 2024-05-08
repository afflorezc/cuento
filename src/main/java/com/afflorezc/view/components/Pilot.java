package com.afflorezc.view.components;

import java.awt.Color;
// cars and Pilot information
public class Pilot {
	
	public String name;
	public int points;
	public int[] currentPos = new int[2];
	public int racePos;
	public int finalPos;
	public int tParameter;
	public Color carColor;
	
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
