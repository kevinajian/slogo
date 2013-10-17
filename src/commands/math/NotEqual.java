package commands.math;

import model.Model;
import commands.Command;

/**
 * Returns 1 if two values are not equal to each other
 * else returns 0
 * @author Kevin
 *
 */
public class NotEqual extends MathTwoInput {
	
	@Override
	public double evaluate(Math model) {
		if(getInputValueOne() != getInputValueTwo()) {
			return 1;
		}
		return 0;
	}
	
}
