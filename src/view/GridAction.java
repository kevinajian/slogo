package view;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import slogoGame.TurtleGame;

@SuppressWarnings("serial")
public class GridAction extends AbstractAction {
	String cmd;
	TurtleGame myGame;
	
	public GridAction(String command, TurtleGame game) {
		super(command);
		cmd = command;
		myGame = game;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(cmd.equals("Toggle Grid Off"))
		{	
			myGame.toggleGrid = false;
		}
		else
			myGame.toggleGrid = true;
	}

}
