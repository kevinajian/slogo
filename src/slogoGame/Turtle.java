package slogoGame;

import org.jbox2d.collision.CircleDef;

import jgame.*;
import jgame.impl.*;

public class Turtle extends JGObject{
	TurtleGame myEngine;
	public Turtle(String name, int collisionid, TurtleGame tgame) {
		super(name, false, 0, 0, collisionid, null);
		myEngine = tgame;
		// TODO Auto-generated constructor stub
	}
	public void paint( )
	{
		myEngine.setColor( JGColor.black );
		myEngine.drawOval( x, y, (float)5*2, (float)5*2, true, true );//radius of 5
	}
}
