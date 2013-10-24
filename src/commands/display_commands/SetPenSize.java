package commands.display_commands;

import model.Model;
import commands.CommandOneInput;

/**
 * Sets the size of the pen to a pixel value which is given as
 * a parameter.
 * @author carlosreyes
 *
 */
public class SetPenSize extends CommandOneInput {

	@Override
	public double evaluate(Model model) {
		model.setPenSize(getInputValueOne(model));
		model.setPenSizeChanged(true);
		return getInputValueOne(model);
	}
}
