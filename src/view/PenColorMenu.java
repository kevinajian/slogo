package view;

import slogoGame.TurtleGame;

@SuppressWarnings("serial")
public class PenColorMenu extends BackgroundMenu {

	public PenColorMenu(String menuName, TurtleGame game) {
		super(menuName, game);
	}
	
	@Override
	public void addAction(String color, TurtleGame game){
		add(new PenColorAction(color,game));
	}
	
}
