package slogoGame;

import jgame.*;
import jgame.platform.JGEngine;

public class Grid extends JGObject{
	private JGEngine myEngine;
	public Grid(String name, int collisionid, JGEngine tgame) {
		super(name, true, tgame.getWidth(), tgame.getHeight(), collisionid, null);
		myEngine = tgame;
	}
	public void paint()
	{
		myEngine.setColor(JGColor.red);
		myEngine.drawLine(0, myEngine.getHeight()/2, myEngine.getWidth(), myEngine.getHeight()/2, 5, JGColor.red);//radius of 5
	}
}
