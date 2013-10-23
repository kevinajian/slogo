package slogoGame;

import java.io.Serializable;

public class ActionGrid extends Action {
	private Boolean toggle;

	public ActionGrid(TurtleGame game, Boolean gridOn) {
		super(game);
		toggle = gridOn;
	}
	
	@Override
	public void redo(){
		myTurtleGame.toggleGrid(toggle);
		}

}
