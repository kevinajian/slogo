package slogoGame;

import jgame.JGColor;
import jgame.JGObject;
import jgame.platform.JGEngine;

public class Line extends JGObject{
	private JGEngine myEngine;
	private double x1;
	private double y1;
	private double x2;
	private double y2;
	JGColor color;
	public Line(String name, int collisionid, JGEngine tgame, double ex1, double why1, double ex2, double why2) {
		super(name, true,0, 0, collisionid, null);
		myEngine = tgame;
		x1 = ex1;
		x2 = ex2;
		y1 = why1;
		y2 = why2;
		color = JGColor.red; //HARD CODED CHANGE FOR LATER
	}
	public void paint()
	{
		myEngine.drawLine(x1, y1, x2, y2, 5, color);
	}
}
