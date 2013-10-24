package commands.display_commands;

import java.util.ArrayList;
import java.util.ResourceBundle;

import model.Model;
import commands.CommandOneInput;

/**
 * Sets the background color to a color corresponding to the index of that
 * number in the drop down menu where 0 is the first number. Input is the command
 * followed by the index of the color desired.
 * @author carlosreyes
 *
 */
public class SetBackground extends SetViewProperties {
	
	@Override
	public double evaluate(Model model) {
		int pos = (int) getInputValueOne(model);
		String bgColor = handleSet(model).get(pos);
		model.setBackgroundColor(bgColor);
		model.setBackgroundChanged(true);
		return getInputValueOne(model);
	}

}
