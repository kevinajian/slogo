package slogoGame;

public class ActionBackground extends Action {
	private String myColor;

	public ActionBackground(TurtleGame game, String color) {
		super(game);
		myColor = color;
	}
	
	@Override
	public void redo(){
		myTurtleGame.setBackgroundColor(myColor);
	}

}
