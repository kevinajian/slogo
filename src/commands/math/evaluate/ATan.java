package commands.math.evaluate;

import commands.OneInput;
import model.Model;

public class ATan extends OneInput {

	@Override
	public double operation(Model model) {
		return Math.atan(getInputValue());
	}

}
