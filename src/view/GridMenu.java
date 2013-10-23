package view;

import javax.swing.JMenu;

import slogoGame.TurtleGame;

import java.util.ResourceBundle;

@SuppressWarnings("serial")
public class GridMenu extends JMenu {

	private ResourceBundle myResources;
	private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";

	public GridMenu(String menuName, TurtleGame game){
		super(menuName);
		myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "English");
		addAction(myResources.getString("GridOn"),game);
		addAction(myResources.getString("GridOff"),game);
		addMouseListener(new MouseFocus(this));
	}
	
	public void addAction(String command, TurtleGame game){
		add(new GridAction(command,game));
	}
	
}