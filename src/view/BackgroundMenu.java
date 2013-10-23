package view;

import javax.swing.JMenu;

import slogoGame.TurtleGame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ResourceBundle;

@SuppressWarnings("serial")
public class BackgroundMenu extends JMenu {

	private ResourceBundle myResources;
	private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";

	public BackgroundMenu(String menuName, TurtleGame game){
		super(menuName);
		myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "English");
		String lumpedColors = myResources.getString("Colors");
		String Colors[] = lumpedColors.split(" ");
		for (String color : Colors){
			addAction(color,game);
		}
		addMouseListener(new MouseFocus(this));
	}
	
	public void addAction(String color, TurtleGame game){
		add(new BackgroundAction(color,game));
	}
	
}
