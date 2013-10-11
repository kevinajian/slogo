package view;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import slogoGame.TurtleGame;

@SuppressWarnings("serial")
public class BackgroundAction extends AbstractAction {
	protected String myColor;
	protected TurtleGame myGame;

	public BackgroundAction(String color,TurtleGame game){
		super(color);
		myColor = color;
		myGame = game;		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		myGame.setBackground(myColor);
	}

}
