package commands.math;

import commands.OneInput;

/**
 * returns random number less than input
 * @author Kevin
 *
 */
public class Random extends OneInput {

	@Override
	public double evaluate() {
		return Math.random()*getInputValueOne();
	}

}
