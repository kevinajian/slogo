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
			l.add(new Line("grid",-DEFAULT_WIDTH/2,-DEFAULT_HEIGHT/2+(DEFAULT_HEIGHT/GRID_DENSITY)*i,
					DEFAULT_WIDTH/2,-DEFAULT_HEIGHT/2+(DEFAULT_HEIGHT/GRID_DENSITY)*i,myEngine));
		}
		//vertical lines
		for(int i = 0; i <= GRID_DENSITY; i++){
			l.add(new Line("grid",-DEFAULT_WIDTH/2+(DEFAULT_WIDTH/GRID_DENSITY)*i,-DEFAULT_HEIGHT/2,
					-DEFAULT_WIDTH/2+(DEFAULT_WIDTH/GRID_DENSITY)*i,DEFAULT_HEIGHT/2,myEngine));
		}		
	}
	
	public void toggle(Boolean gridOn)
	{
		for (Line line : l){
			if (gridOn){
				line.resume();
				resume();
			}
			else{
				line.suspend();
				suspend();
			}
		}	
	}
}
