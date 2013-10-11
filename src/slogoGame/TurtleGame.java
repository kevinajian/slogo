package slogoGame;

import jgame.JGColor;
import jgame.impl.*;
import jgame.JGFont;
import jgame.JGPoint;
import jgame.platform.JGEngine;

@SuppressWarnings("serial")
public class TurtleGame extends JGEngine{
	private JGColor myPenColor;
	private JGColor myBackgroundColor;
	public Turtle squirt;
	
	public TurtleGame() {initEngineApplet();}

	public void initCanvas() { 
		initEngineApplet();
		setCanvasSettings(80,30,16,16,JGColor.blue,JGColor.blue,null); 
	}
	
	public TurtleGame(JGPoint size) {initEngine(size.x,size.y);}
	
	public void initGame() {
		setFrameRate(45,2);
		setCursor(null);
		defineImages();
		squirt = new Turtle("turtle", 50, this);
		setGameState("Title");
	}
	
	public void paint()
	{

	}
	public void defineImages(){
		//defineImage("loser","-",0,"loser.png","-");
	}
	
	public void startTitle() {
		removeObjects(null,0);
	}

	public void paintFrameTitle() {
		squirt.paint();
	}
	
	public void doFrameTitle() {

	}
}
