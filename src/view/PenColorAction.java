package view;

import java.awt.event.ActionEvent;

import slogoGame.TurtleGame;

@SuppressWarnings("serial")
public class PenColorAction extends BackgroundAction {

	public PenColorAction(String color, TurtleGame game) {
		super(color, game);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		myGame.setPenColor(myColor);
	}


}
