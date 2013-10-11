package view;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JMenu;

import slogoGame.TurtleGame;

import java.util.ResourceBundle;

@SuppressWarnings("serial")
public class ColorMenu extends JMenu {

	private ResourceBundle myResources;
	private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";

	public ColorMenu(String menuName, TurtleGame game){
		super(menuName);
		myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "English");
		
		add(new ColorAction(myResources.getString("Color1"),game));
	}
}
