package commands.math;

import model.Model;
import commands.TwoInput;

/**
 * returns 1 if the first input is greater than the second
 * else returns 0
 * @author Kevin
 *
 */
public class Greater extends TwoInput{
	
	@Override
	public double evaluate(Model model) {
		if (getInputValueOne() > getInputValueTwo()) {
			return 1;
		}
		return 0;
	}
	
}
