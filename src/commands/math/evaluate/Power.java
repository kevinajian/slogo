package commands.math.evaluate;

import commands.OneInput;
import model.Model;

public class Power extends OneInput{

	@Override
	public double operation(Model model) {
		//FIX THIS
		return Math.pow(getInputValue(), 0);
	}

}
