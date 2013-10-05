package view;

import jgame.JGPoint;
import jgame.platform.JGEngine;

public class TurtleGame extends JGEngine{

	public TurtleGame() {initEngineApplet();}

	public void initCanvas() { setCanvasSettings(80,30,16,16,null,null,null); }
	
	public TurtleGame(JGPoint size) {initEngine(size.x,size.y);}
	
	public void initGame() {
		setFrameRate(45,2);
		setCursor(null);
		setGameState("Title");
	}

}
