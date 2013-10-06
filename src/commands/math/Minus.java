package commands.math;

import commands.OneInput;
import model.Model;

public class Minus extends OneInput{

	@Override
	public double operation(Model model) {
		return -getInputValue();
	}

}
