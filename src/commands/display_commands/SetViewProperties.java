package commands.display_commands;

import java.util.ArrayList;
import java.util.ResourceBundle;

import model.Model;
import commands.CommandOneInput;

public class SetViewProperties extends CommandOneInput {
	protected ResourceBundle myResources;
	protected static final String DEFAULT_RESOURCE_PACKAGE = "resources.";
	
	protected ArrayList<String> handleSet(Model model) {
		myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "English");
		String lumpedColors = myResources.getString("Colors");
		String colors1[] = lumpedColors.split(" ");
		ArrayList<String> colors = new ArrayList<String>();
		for(int i = 0; i<colors1.length-1;i++){
			colors.add(colors1[i]);
		}
		return colors;
	}
	
}
