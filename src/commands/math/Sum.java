package commands.math;

import model.Model;
import commands.TwoInput;

/**
 * Takes the sum of two values.
 * Ex. 4+2 = 6
 * @author carlosreyes
 *
 */
public class Sum extends TwoInput {
	
	@Override
	public double evaluate(Model model) {
		return getInputValueOne() + getInputValueTwo();
	}

}
