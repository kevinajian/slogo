package view;

import javax.swing.JMenu;

import slogoGame.TurtleGame;

@SuppressWarnings("serial")
public class WorkspaceMenu extends JMenu {
	private TurtleGame myGame;
	private int myIndex;

	public WorkspaceMenu(String menuName, TurtleGame game){
		super(menuName);
		myGame = game;
		myIndex = 1;
		add(new WorkspaceMenuAction(this));
		addAction();
		addMouseListener(new MouseFocus(this));
	}
	
	public void addAction(){
		add(new WorkspaceAction(myIndex,myGame));
		myIndex++;
	}
	
	
	
}
