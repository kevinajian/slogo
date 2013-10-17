package commands.math;

import model.Model;
import commands.Command;

/**
 * Returns power of input value
 * @author Kevin
 *
 */
public class Pow extends MathTwoInput {

	@Override
	public double evaluate(Math model) {
		return Math.pow(getInputValueOne(), getInputValueTwo());
	}

}
