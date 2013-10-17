package commands.math;

import model.Model;
import commands.Command;

/**
 * Returns tan of input value
 * @author Kevin, Carlos
 *
 */
public class Tan extends MathOneInput {

	@Override
	public double evaluate(Math model) {
		return Math.tan(Math.toRadians(getInputValueOne()));
	}

}
