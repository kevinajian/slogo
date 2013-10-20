package commands.display_commands;

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
		String Colors[] = lumpedColors.split(" ");
		int pos = (int) getInputValueOne(model);
		String bgColor = Colors[pos];
		model.setMyBackgroundColor(bgColor);
		return getInputValueOne(model);
	}

}
