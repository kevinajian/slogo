package commands.math.arithmetic;

import model.Model;
import commands.TwoInput;

/**
 * Returns the remainder of division
 * @author Kevin
 */
public class Remainder extends TwoInput {

	@Override
	public double operation(Model model) {
		return getInputValueOne() % getInputValueTwo();
	}

	
}
