package commands.math;

import commands.OneInput;

/**
 * returns negative of input value
 * @author Kevin
 *
 */
public class Minus extends OneInput{

	@Override
	public double evaluate() {
		return -getInputValueOne();
	}

}
