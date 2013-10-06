package commands.math;

import commands.TwoInput;
import model.Model;

/**
 * Takes the sum of two values.
 * Ex. 4+2 = 6
 * @author carlosreyes
 *
 */
public class Sum extends TwoInput {
	
	@Override
	public double operation(Model model) {
		return getInputValueOne() + getInputValueTwo();
	}

}
