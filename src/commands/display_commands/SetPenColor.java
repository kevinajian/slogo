package commands.display_commands;

import java.util.ArrayList;
import java.util.ResourceBundle;

import commands.CommandOneInput;

import model.Model;

/**
 * Sets the color of the pen to the color corresponding to the position,
 * starting at 0, of the color in the drop down menu.
 * @author carlosreyes
 *
 */
public class SetPenColor extends SetViewProperties {

	@Override
	public double evaluate(Model model) {
		ArrayList<String> colors = handleSet(model);
		int pos = (int) getInputValueOne(model);
		String penColor = colors.get(pos);
		model.setPenColor(penColor);
		model.setPenColorChanged(true);
		return getInputValueOne(model);
	}
}
