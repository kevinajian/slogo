package slogoGame;

import java.io.Serializable;

public class Action implements Serializable{
	protected TurtleGame myTurtleGame;

	public Action(TurtleGame game) {
		myTurtleGame = game;
	}
	
	public void redo(){
		
	}
}
