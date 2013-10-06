package commands.math;

import model.Model;
import commands.TwoInput;

/**
 * returns 1 if the first input is less than the second input
 * else returns 0
 * @author Kevin
 *
 */
public class Less extends TwoInput {

	@Override
	public double evaluate() {
		if (getInputValueOne() < getInputValueTwo()) {
			return 1;
		}
		return 0;
	}
	
}
