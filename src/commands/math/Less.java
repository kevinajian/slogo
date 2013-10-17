package commands.math;

import model.Model;
import commands.Command;

/**
 * Returns 1 if the first input is less than the second input
 * else returns 0
 * @author Kevin
 *
 */
public class Less extends MathTwoInput {

	@Override
	public double evaluate(Math model) {
		if (getInputValueOne() < getInputValueTwo()) {
			return 1;
		}
		return 0;
	}
	
}
