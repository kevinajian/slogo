package commands.math;

import model.Model;
import commands.Command;

/**
 * returns Random number less than input
 * @author Kevin
 *
 */
public class Random extends MathOneInput {

	@Override
	public double evaluate(Math model) {
		return Math.random()*getInputValueOne();
	}

}
