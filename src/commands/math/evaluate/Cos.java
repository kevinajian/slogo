package commands.math.evaluate;

import commands.OneInput;
import model.Model;

public class Cos extends OneInput{

	@Override
	public double operation(Model model) {
		return Math.cos(getInputValue());
	}

}
