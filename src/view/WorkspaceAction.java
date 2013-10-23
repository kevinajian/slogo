package view;

import java.awt.event.ActionEvent;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;

import slogoGame.TurtleGame;

@SuppressWarnings("serial")
public class WorkspaceAction extends AbstractAction {
	protected int myID;
	protected TurtleGame myGame;

	public WorkspaceAction(int number,TurtleGame game){
		super(ResourceBundle.getBundle("resources.English").getString("Workspace") + " " + number);
		myID = number;
		myGame = game;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		myGame.setWorkspace(myID - 1);
	}

}
