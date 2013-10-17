package commands.math;

import model.Model;
import commands.Command;

/**
 * cos operation on one input
 * @author Kevin, Carlos
 *
 */
public class Cos extends MathOneInput{

	@Override
	public double evaluate(Math model) {
		return Math.cos(Math.toRadians(getInputValueOne()));
	}

}
