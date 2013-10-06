package commands.math;

import commands.OneInput;

/**
 * cos operation on one input
 * @author Kevin, Carlos
 *
 */
public class Cos extends OneInput{

	@Override
	public double evaluate() {
		return Math.cos(Math.toRadians(getInputValueOne()));
	}

}
