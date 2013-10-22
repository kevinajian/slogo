package commands.display_commands;

import model.Model;
import commands.CommandZeroInput;

public class Stamp extends CommandZeroInput {
	
	@Override
	public double evaluate(Model model) {
		model.setStamp(true);
		return 0;
	}
	
}
