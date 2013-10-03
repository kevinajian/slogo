package commands.math.evaluate;

import commands.OneInput;
import model.Model;

public class Sin extends OneInput{

	@Override
	public double operation(Model model) {
		return Math.sin(getInputValue());
	}

}
