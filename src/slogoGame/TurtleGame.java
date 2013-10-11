package slogoGame;

import jgame.JGColor;
import jgame.impl.*;
import jgame.JGFont;
import jgame.JGPoint;
import jgame.platform.JGEngine;

import java.awt.Color;
import java.util.*;
import javax.swing.JColorChooser;

@SuppressWarnings("serial")
public class TurtleGame extends JGEngine{
	private JGColor myPenColor;
	private JGColor myBackgroundColor;
	private Map<String,JGColor> colorMap = new HashMap<String,JGColor>();
	public Turtle squirt;
	public Grid g;
	/*	public TurtleGame() {initEngineApplet();}

	public void initCanvas() { 
		initEngineApplet();
		setCanvasSettings(80,30,16,16,JGColor.blue,JGColor.blue,null); 
	}*/

	public TurtleGame() {initEngine(800, 600);}

	public void initCanvas() { 
		initEngineApplet();
		setCanvasSettings(80,30,16,16,JGColor.blue,JGColor.white,null); 
	}

	public TurtleGame(JGPoint size) {initEngine(size.x,size.y);}

	public void initGame() {
		setFrameRate(45,2);
		setCursor(null);
		defineImages();
		squirt = new Turtle("turtle", 50, this);
		g = new Grid("grid", 69, this);
		colorMap.put("Blue", JGColor.blue);
		colorMap.put("Red", JGColor.red);
		colorMap.put("White", JGColor.white);
		colorMap.put("Black", JGColor.black);		
		setGameState("Title");
	}

	public void setBackground(String color){
		JGColor colorBG = getJGColor(color);
		if (colorBG == null)
			return;
		setBGColor(colorBG);
		setBGImage(null);
	}

	public void setPenColor(String color){
		JGColor colorBG = getJGColor(color);
		if (colorBG == null)
			return;
		myPenColor = colorBG;
	}

	private JGColor getJGColor(String color){
		if (colorMap.containsKey(color)){
			return colorMap.get(color);
		}
		else {
			new JColorChooser();
			Color myColor = JColorChooser.showDialog(this, "Background Color", new Color(0));
			if (myColor == null)
				return null;
			return new JGColor(myColor.getRed(), myColor.getGreen(), myColor.getBlue());
		}
	}

	public void defineImages(){
		//defineImage("loser","-",0,"loser.png","-");
	}

	public void startTitle() {
		removeObjects(null,0);
	}

	public void paintFrameTitle() {
		squirt.paint();
		g.paint();
	}

	public void doFrameTitle() {

	}
}
