package view;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import slogoGame.TurtleGame;

@SuppressWarnings("serial")
public class ToggleAction extends AbstractAction {
	TurtleGame myGame;
	String cmd;
	
	public ToggleAction(String command, TurtleGame game){
		super(command);
		cmd = command;
		myGame = game;		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		myGame.makeBorderAction(!cmd.equals("Toggle Border Off"));
		System.out.println("TOGGLING BORDER OFF");
	}

}
