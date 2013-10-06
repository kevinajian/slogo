package commands.math;

import commands.OneInput;
import model.Model;

public class Cos extends OneInput{

	@Override
	public double operation(Model model) {
		return Math.cos(getInputValue());
	}

}
