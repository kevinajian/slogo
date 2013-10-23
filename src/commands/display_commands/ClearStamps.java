package commands.display_commands;

import model.Model;
import commands.CommandZeroInput;

public class ClearStamps extends CommandZeroInput {

	@Override
	public double evaluate(Model model) {
		model.clearStamps();
		return 0;
	}	
}
