package commands.interaction_commands;

import model.Model;
import commands.CommandZeroInput;

public class OnClick extends CommandZeroInput{
	
	@Override
	public double evaluate(Model model) {
		System.out.println(model.getMouseX());
		return myNumInputs;
		
	}
}
