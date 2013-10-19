package slogoGame;

import java.util.ArrayList;

import jgame.JGColor;
import jgame.JGObject;
import jgame.platform.JGEngine;

public class Lines extends JGObject implements Constants {
	
	private JGEngine myEngine;
	private String myImage;
	private String myName;
	private boolean amCustom;
	
	private ArrayList<ArrayList<Double>> linesArray = new ArrayList<ArrayList<Double>>();
	
	public Lines(String name, int collisionid, JGEngine tgame) {
		super(name, false, 0, 0, collisionid, null);
		myEngine = tgame;
		myName = "turtle";
		myImage = myName+0;
		amCustom = false;
	}
	
	public void paint()
	{
		for(ArrayList<Double> mini : linesArray){
			myEngine.drawLine(mini.get(0), mini.get(1), mini.get(2), mini.get(3), mini.get(4), JGColor.black);
			//myEngine.drawLine(x1, y1, x2, y2, thickness, JGColor.black);
		}
	}
	
	public void drawPath(double[] currentLine) {
		
		double x1;
		double y1;
		double x2;
		double y2;
		ArrayList<Double> miniArray = new ArrayList<Double>();
		
		x1 = pfwidth/2 + currentLine[0];
		y1 = pfheight/2 + -currentLine[1];
		x2 = pfwidth/2 + currentLine[2];
		y2 = pfheight/2 + -currentLine[3];
		miniArray.add(x1); miniArray.add(y1); miniArray.add(x2); miniArray.add(y2); miniArray.add(4.0);
		System.out.println(miniArray);

		linesArray.add(miniArray);
		System.out.println(linesArray.size());

	}

}
