package commands.math;

import model.Model;
import commands.OneInput;

/**
 * returns 1 if input value is 0
 * else returns 0
 * @author Kevin
 *
 */
public class Not extends OneInput {

	@Override
	public double evaluate() {
		if (getInputValueOne() == 0) {
			return 1;
		}
		return 0;
	}

}
