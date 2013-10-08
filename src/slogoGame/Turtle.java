package slogoGame;

import org.jbox2d.collision.CircleDef;

import jgame.*;
import jgame.impl.*;
import jgame.platform.JGEngine;

public class Turtle extends JGObject{
	private JGEngine myEngine;
	public Turtle(String name, int collisionid, JGEngine tgame) {
		super(name, true, tgame.getWidth(), tgame.getHeight(), collisionid, null);
		myEngine = tgame;
		// TODO Auto-generated constructor stub
	}
	public void paint()
	{
		myEngine.setColor( JGColor.red );
		myEngine.drawOval(myEngine.getWidth(), 50, (float)5*2, (float)5*2, true, true );//radius of 5
	}
}
