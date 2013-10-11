package slogoGame;

import java.util.ArrayList;

import jgame.*;
import jgame.platform.JGEngine;

public class Grid extends JGObject implements Constants{
	private TurtleGame myEngine;
	ArrayList<Line> l;
	public Grid(String name, int collisionid, TurtleGame tgame) {
		super(name, true, tgame.getWidth(), tgame.getHeight(), collisionid, null);
		myEngine = tgame;
		l = new ArrayList<Line>();
		int xNum = DEFAULT_WIDTH/GRID_DENSITY;
		int yNum = DEFAULT_HEIGHT/GRID_DENSITY;
		
		//horizontal lines
		for(int i = 0; i <= GRID_DENSITY; i++){
			l.add(new Line(-DEFAULT_WIDTH/2,-DEFAULT_HEIGHT/2+(DEFAULT_HEIGHT/GRID_DENSITY)*i,
					DEFAULT_WIDTH/2,-DEFAULT_HEIGHT/2+(DEFAULT_HEIGHT/GRID_DENSITY)*i,myEngine));
		}
		//vertical lines
		for(int i = 0; i <= GRID_DENSITY; i++){
			l.add(new Line(-DEFAULT_WIDTH/2+(DEFAULT_WIDTH/GRID_DENSITY)*i,-DEFAULT_HEIGHT/2,
					-DEFAULT_WIDTH/2+(DEFAULT_WIDTH/GRID_DENSITY)*i,DEFAULT_HEIGHT/2,myEngine));
		}		
		
/*		for (int i = 0; i <= num; i++) //horizontal lines
		{
			l.add(new Line("line", 10, myEngine, 0 - DEFAULT_WIDTH/2, (yNum-DEFAULT_HEIGHT/2)*i, 
					myEngine.viewWidth() - DEFAULT_WIDTH/2, (yNum-DEFAULT_HEIGHT/2)*i));
		}
		for (int i = 0; i <= num; i++) //vertical lines
		{
			l.add(new Line("line", 10, myEngine, (xNum-DEFAULT_WIDTH/2)*i, 0-DEFAULT_HEIGHT/2, 
					(xNum-DEFAULT_WIDTH/2)*i, myEngine.viewHeight()-DEFAULT_HEIGHT/2));
		}*/
		
		
	}
	public void paint()
	{
		for (Line line : l)
			line.paint();
	}
}
