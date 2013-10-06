package commands.math;

import commands.TwoInput;

/**
 * returns 1 if two values are not equal to each other
 * else returns 0
 * @author Kevin
 *
 */
public class NotEqual extends TwoInput {
	
	@Override
	public double evaluate() {
		if(getInputValueOne() != getInputValueTwo()) {
			return 1;
		}
		return 0;
	}
	
}
