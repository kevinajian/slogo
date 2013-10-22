package commands.display_commands;

import java.util.ResourceBundle;
import model.Model;
import commands.CommandZeroInput;

public class Shape extends CommandZeroInput {	
	private ResourceBundle myResources;
	private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";
	
	@Override
	public double evaluate(Model model) {
		myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "English");
		String lumpedShapes = myResources.getString("TurtleCommands");
		String turtleCommands[] = lumpedShapes.split(" ");
		
		String shape = model.getShape();
		for(int i = 0; i<turtleCommands.length;i++){
			if(shape.equals(turtleCommands[i])){
				return i;
			}
		}
		return 0;
	}
}
