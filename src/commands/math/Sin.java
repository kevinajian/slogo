package commands.math;

import commands.OneInput;

/**
 * returns sin of input value
 * @author Kevin, Carlos
 *
 */
public class Sin extends OneInput{

	@Override
	public double evaluate() {
		return Math.sin(Math.toRadians(getInputValueOne()));
	}

}
