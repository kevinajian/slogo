package slogoGame;

import jgame.JGColor;
import jgame.JGPoint;
import jgame.platform.JGEngine;

@SuppressWarnings("serial")
public class TurtleGame extends JGEngine{
	private Turtle squirt;
	
	public TurtleGame() {initEngineApplet();}

	public void initCanvas() { 
		initEngineApplet();
		//squirt = new Turtle("turtle", 0, this);
		setCanvasSettings(80,30,16,16,JGColor.blue,JGColor.blue,null); 
	}
	
	public TurtleGame(JGPoint size) {initEngine(size.x,size.y);}
	
	public void initGame() {
		setFrameRate(45,2);
		setCursor(null);
		defineImages();
		setGameState("Title");
	}
	
	public void paint()
	{
		squirt.paint();
	}
	public void defineImages(){
		//defineImage("loser","-",0,"loser.png","-");
	}
	
	public void startTitle() {
		removeObjects(null,0);
	}

	public void paintFrameTitle() {

	}
	
	public void doFrameTitle() {

	}
}
