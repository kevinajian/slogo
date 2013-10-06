package commands.math;

import commands.OneInput;
import model.Model;

public class Tan extends OneInput {

	@Override
	public double operation(Model model) {
		return Math.tan(getInputValue());
	}

}
