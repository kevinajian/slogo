package commands.math;

import model.Model;
import commands.Command;

/**
 * Returns negative of input value
 * @author Kevin
 *
 */
public class Minus extends MathOneInput{

	@Override
	public double evaluate(Math model) {
		return -getInputValueOne();
	}

}
