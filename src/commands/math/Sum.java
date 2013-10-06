package commands.math;

import commands.TwoInput;

/**
 * Takes the sum of two values.
 * Ex. 4+2 = 6
 * @author carlosreyes
 *
 */
public class Sum extends TwoInput {
	
	@Override
	public double evaluate() {
		return getInputValueOne() + getInputValueTwo();
	}

}
