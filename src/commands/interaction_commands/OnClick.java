package commands.interaction_commands;

import model.Model;
import commands.Command;
import commands.CommandZeroInput;

public class OnClick extends Command {
	
	@Override
	public double evaluate(Model model) {
		System.out.println(getInputValueOne(model) + " " + getInputValueTwo(model));
		return myNumInputs;
		
	}
}
