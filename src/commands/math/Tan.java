package commands.math;

import commands.OneInput;

/**
 * returns tan of input value
 * @author Kevin, Carlos
 *
 */
public class Tan extends OneInput {

	@Override
	public double evaluate() {
		return Math.tan(Math.toRadians(getInputValueOne()));
	}

}
