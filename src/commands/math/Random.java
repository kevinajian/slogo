package commands.math;

import model.Model;
import commands.OneInput;

/**
 * returns random number less than input
 * @author Kevin
 *
 */
public class Random extends OneInput {

	@Override
	public double evaluate(Model model) {
		return Math.random()*getInputValueOne();
	}

}
