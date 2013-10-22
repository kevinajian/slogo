package commands.display_commands;

import java.util.ArrayList;
import java.util.ResourceBundle;

import model.Model;

import commands.CommandOneInput;

public class SetShape extends CommandOneInput {
	private ResourceBundle myResources;
	private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";
	
	@Override
	public double evaluate(Model model) {
		myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "English");
		String lumpedColors = myResources.getString("TurtleCommands");
		String turtleCommands1[] = lumpedColors.split(" ");
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
