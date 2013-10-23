package view;

import javax.swing.JMenu;

import slogoGame.TurtleGame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ResourceBundle;

@SuppressWarnings("serial")
public class TurtleToggleMenu extends JMenu {

	private ResourceBundle myResources;
	private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";

	public TurtleToggleMenu(String menuName, TurtleGame game){
		super(menuName);
		myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "English");
		add(new ToggleAction(myResources.getString("Toggle"),game));
		addMouseListener(new MouseFocus(this));
	}
	
}
