package view;

import jgame.JGColor;
import jgame.JGPoint;
import jgame.platform.JGEngine;

public class TurtleGame extends JGEngine{

	public TurtleGame() {initEngineApplet();}

	public void initCanvas() { 
		initEngineApplet();
		setCanvasSettings(80,30,16,16,JGColor.blue,JGColor.blue,null); 
	}
	
	public TurtleGame(JGPoint size) {initEngine(size.x,size.y);}
	
	public void initGame() {
		setFrameRate(45,2);
		setCursor(null);
		setGameState("Title");
	}	

}
