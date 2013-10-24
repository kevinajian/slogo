package commands.display_commands;

import java.util.ArrayList;
import java.util.ResourceBundle;

import model.Model;
import model.TurtleCommands;

import commands.CommandOneInput;

/**
 * Sets the turtle image to the number (starting at 0) corresponding to the image
 * in the drop down turtle image selection menu.
 * @author carlosreyes
 *
 */
public class SetShape extends SetViewProperties {
	
	@Override
	public double evaluate(Model model) {
		ArrayList<String> turtleCommands = handleSet(model);
		int pos = (int) getInputValueOne(model);
		String shape = turtleCommands.get(pos);
		model.setShape(shape);
		model.setShapeChanged(true);
		return getInputValueOne(model);
	}
}
