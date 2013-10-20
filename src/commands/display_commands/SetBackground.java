package commands.display_commands;

import java.util.ArrayList;
import java.util.ResourceBundle;

import model.Model;
import commands.CommandOneInput;

public class SetBackground extends CommandOneInput {
	private ResourceBundle myResources;
	private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";


	@Override
	public double evaluate(Model model) {
		myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "English");
		String lumpedColors = myResources.getString("Colors");
		String colors1[] = lumpedColors.split(" ");
		ArrayList<String> colors = new ArrayList<String>();
		for(int i = 0; i<colors1.length-1;i++){
			colors.add(colors1[i]);
		}
		int pos = (int) getInputValueOne(model);
		String bgColor = colors.get(pos);
		model.setMyBackgroundColor(bgColor);
		return getInputValueOne(model);
	}

}
