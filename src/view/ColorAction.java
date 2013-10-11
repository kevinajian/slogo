package view;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import slogoGame.TurtleGame;

@SuppressWarnings("serial")
public class ColorAction extends AbstractAction {
	private String myColor;
	private TurtleGame myGame;

	public ColorAction(String color,TurtleGame game){
		super(color);
		myColor = color;
		myGame = game;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
