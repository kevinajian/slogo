package view;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import slogoGame.TurtleGame;

@SuppressWarnings("serial")
public class TurtleAction extends AbstractAction {
	private String myTurtleImage;
	private TurtleGame myGame;

	public TurtleAction(String command,TurtleGame game){
		super(command);
		myGame = game;
		myTurtleImage = command;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		myGame.setTurtleImage(myTurtleImage);
	}
	
}
