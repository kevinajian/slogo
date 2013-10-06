package commands.math;

import model.Model;
import commands.TwoInput;

/**
 * Takes the quotient of two values.
 * Ex. 4-2 = 2
 * @author carlosreyes
 *
 */
public class Difference extends TwoInput {

	@Override
	public double operation(Model model) {
		return getInputValueOne() - getInputValueTwo();
	}

}