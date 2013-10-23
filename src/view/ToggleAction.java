package view;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import slogoGame.TurtleGame;

@SuppressWarnings("serial")
public class ToggleAction extends AbstractAction {
	protected TurtleGame myGame;

	public ToggleAction(String name, TurtleGame game){
		super(name);
		myGame = game;		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		myGame.toggleHighlightBorder();
	}

}
