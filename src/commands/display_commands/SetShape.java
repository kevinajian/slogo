package commands.display_commands;

import java.util.ArrayList;
import java.util.ResourceBundle;

import model.Model;

import commands.CommandOneInput;

/**
 * Sets the turtle image to the number (starting at 0) corresponding to the image
 * in the drop down turtle image selection menu.
 * @author carlosreyes
 *
 */
public class SetShape extends CommandOneInput {
	private ResourceBundle myResources;
	private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";
	
	@Override
	public double evaluate(Model model) {
		myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "English");
		String lumpedShape = myResources.getString("TurtleCommands");
		String turtleCommands1[] = lumpedShape.split(" ");
		ArrayList<String> turtleCommands = new ArrayList<String>();
		for(int i = 0; i<turtleCommands1.length-1;i++){
			turtleCommands.add(turtleCommands1[i]);
		}
		int pos = (int) getInputValueOne(model);
		String shape = turtleCommands.get(pos);
		model.setShape(shape);
		model.setShapeChanged(true);
		return getInputValueOne(model);
	}
}
