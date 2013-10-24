package slogoGame;

import jgame.JGColor;
import jgame.JGObject;

public class Line extends JGObject implements Constants{
	private TurtleGame myEngine;
	private JGColor myColor;
	private double x1;
	private double y1;
	private double x2;
	private double y2;

	public Line(double ex1, double why1, double ex2, double why2, TurtleGame tgame){
		this("line",0,tgame,ex1,why1,ex2,why2);
	}

	public Line(String name, double ex1, double why1, double ex2, double why2, TurtleGame tgame){
		this(name,0,tgame,ex1,why1,ex2,why2);
	}

	public Line(String name, int collisionid, TurtleGame tgame, double ex1, double why1, double ex2, double why2) {
		super(name, true,0, 0, collisionid, null);
		myEngine = tgame;
		myColor = myEngine.getPenColor();
		
		x1 = ex1 + DEFAULT_WIDTH/2;
		x2 = ex2 + DEFAULT_WIDTH/2;
		y1 = -why1 + DEFAULT_HEIGHT/2;
		y2 = -why2 + DEFAULT_HEIGHT/2;
	}

	public void paint()
	{
		myEngine.drawLine(x1, y1, x2, y2, myEngine.getPenSize(), myColor);
	}
}
