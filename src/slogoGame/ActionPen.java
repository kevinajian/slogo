package slogoGame;

import java.io.Serializable;

public class ActionPen extends Action {
	private String myColor;

	public ActionPen(TurtleGame game, String color) {
		super(game);
		myColor = color;
	}

	@Override
	public void redo(){
		myTurtleGame.setPenColor(myColor);
	}
	
}
