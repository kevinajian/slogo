package view;

import javax.swing.JMenu;

import slogoGame.TurtleGame;

import java.util.ResourceBundle;

@SuppressWarnings("serial")
public class TurtleMenu extends JMenu {
	private ResourceBundle myResources;
	private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";

	public TurtleMenu(String menuName, TurtleGame game){
		super(menuName);
		myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "English");
		String lumpedColors = myResources.getString("TurtleCommands");
		String commands[] = lumpedColors.split(" ");
		for (String command : commands)
			add(new TurtleAction(command,game));
		addMouseListener(new MouseFocus(this));
	}
}
