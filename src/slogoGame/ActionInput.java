package slogoGame;

public class ActionInput extends Action {
	private String myString;

	public ActionInput(TurtleGame game, String string) {
		super(game);
		myString = string;
	}

	@Override
	public void redo(){
		try {
			myTurtleGame.sendString(myString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
