package commands.math.arithmetic;

import commands.TwoInput;
import model.Model;

/**
 * Takes the quotient of two values.
 * Ex. 4/2 = 2
 * @author carlosreyes
 *
 */
public class Quotient extends TwoInput {

	@Override
	public double operation(Model model) {
		return getInputValueOne() / getInputValueTwo();
	}

}
