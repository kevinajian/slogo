package commands.math;

import model.Model;
import commands.Command;

/**
 * Returns 1 if the first input is greater than the second
 * else returns 0
 * @author Kevin
 *
 */
public class Greater extends MathTwoInput {
	
	@Override
	public double evaluate(Math model) {
		if (getInputValueOne() > getInputValueTwo()) {
			return 1;
		}
		return 0;
	}
	
}
