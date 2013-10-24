package commands.math;

import model.MathModel;
import model.Model;
import commands.Command;
import commands.CommandOneInput;

public abstract class MathOneInput extends CommandOneInput {
	
	@Override
	public double evaluate(Model model) {
		return myNumInputs;
		
	}
}