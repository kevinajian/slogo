package slogoGame;

public class ActionBorder extends Action {
	private Boolean toggle;
	
	public ActionBorder(TurtleGame game, Boolean borderOn) {
		super(game);
		toggle = borderOn;
	}
	
	@Override
	public void redo(){
		myTurtleGame.setBorder(toggle);
	}
}
