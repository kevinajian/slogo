package commands.math;

import commands.OneInput;

/**
 * atan operation on one input
 * @author Kevin, Carlos
 *
 */
public class ATan extends OneInput {

	@Override
	public double evaluate() {
		return Math.atan(getInputValueOne());
	}

}
