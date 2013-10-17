package commands.math;

import model.Model;
import commands.Command;

/**
 * Returns 1 if input value is 0
 * else returns 0
 * @author Kevin
 *
 */
public class Not extends MathOneInput {

	@Override
	public double evaluate(Math model) {
		if (getInputValueOne() == 0) {
			return 1;
		}
		return 0;
	}

}
