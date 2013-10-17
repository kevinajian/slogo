package commands.math;

import model.Model;
import commands.Command;

/**
 * Takes the log of the input value
 * @author Kevin
 *
 */
public class Log extends MathOneInput {

	@Override
	public double evaluate(Math model) {
		return Math.log(getInputValueOne());
	}

}
