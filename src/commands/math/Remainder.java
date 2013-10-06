package commands.math;

import commands.TwoInput;

/**
 * Returns the remainder of division
 * @author Kevin
 */
public class Remainder extends TwoInput {

	@Override
	public double evaluate() {
		return getInputValueOne() % getInputValueTwo();
	}

	
}
