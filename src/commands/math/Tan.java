package commands.math;

import commands.OneInput;
import model.Model;

/**
 * returns tan of input value
 * @author Kevin
 *
 */
public class Tan extends OneInput {

	@Override
	public double evaluate() {
		return Math.tan(getInputValueOne());
	}

}
