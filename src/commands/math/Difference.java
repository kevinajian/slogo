package commands.math;

import commands.TwoInput;

/**
 * Takes the difference of two values.
 * Ex. 4-2 = 2
 * @author carlosreyes
 *
 */
public class Difference extends TwoInput {

	@Override
	public double evaluate() {
		return getInputValueOne() - getInputValueTwo();
	}

}