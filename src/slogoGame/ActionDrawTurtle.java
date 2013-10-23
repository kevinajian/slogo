package slogoGame;

import java.io.Serializable;

public class ActionDrawTurtle extends Action {
	private double[] myPosition;

	public ActionDrawTurtle(TurtleGame game, double[] position) {
		super(game);
		myPosition = position;
	}
	
	@Override
	public void redo(){
		myTurtleGame.drawTurtleActually(myPosition);
	}

}
