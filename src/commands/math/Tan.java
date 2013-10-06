package commands.math;

import model.Model;
import commands.OneInput;

/**
 * returns tan of input value
 * @author Kevin, Carlos
 *
 */
public class Tan extends OneInput {

	@Override
	public double evaluate(Model model) {
		return Math.tan(Math.toRadians(getInputValueOne()));
	}

}
