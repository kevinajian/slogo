package commands.math;

import commands.OneInput;

/**
 * returns power of input value
 * @author Kevin
 *
 */
public class Power extends OneInput{

	@Override
	public double evaluate() {
		//FIX THIS
		return Math.pow(getInputValueOne(), 0);
	}

}
