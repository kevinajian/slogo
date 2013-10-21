package commands.display_commands;

import model.Model;
import commands.CommandOneInput;

public class SetPenSize extends CommandOneInput {

	@Override
	public double evaluate(Model model) {
		model.setPenSize(getInputValueOne(model));
		model.setPenSizeChanged(true);
		return getInputValueOne(model);
	}
}
