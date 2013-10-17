package commands.math;

import model.Model;
import commands.Command;

/**
 * Returns 1 if two inputs are not zero
 * else returns 0
 * @author Kevin
 */
public class And extends MathTwoInput {

	@Override
	public double evaluate(Math model) {
		if ((getInputValueTwo() != 0) && (getInputValueOne() != 0)) {
			return 1;
		}
		return 0;
	}
}