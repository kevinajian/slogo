package commands.math;

import model.Model;
import commands.Command;

/**
 * Returns sin of input value
 * @author Kevin, Carlos
 *
 */
public class Sin extends MathOneInput {

	@Override
	public double evaluate(Math model) {
		return Math.sin(Math.toRadians(getInputValueOne()));
	}

}
