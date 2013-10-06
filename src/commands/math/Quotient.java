package commands.math;

import commands.TwoInput;

/**
 * Takes the quotient of two values.
 * Ex. 4/2 = 2
 * @author carlosreyes
 *
 */
public class Quotient extends TwoInput {

	@Override
	public double evaluate() {
		return getInputValueOne() / getInputValueTwo();
	}

}
