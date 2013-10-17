package commands.math;

import model.Model;
import commands.Command;

/**
 * Atan operation on one input
 * @author Kevin, Carlos
 *
 */
public class ATan extends MathOneInput {

	@Override
	public double evaluate(Math model) {
		return Math.atan(getInputValueOne());
	}

}
