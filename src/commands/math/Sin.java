package commands.math;

import commands.OneInput;
import model.Model;

public class Sin extends OneInput{

	@Override
	public double operation(Model model) {
		return Math.sin(getInputValue());
	}

}
