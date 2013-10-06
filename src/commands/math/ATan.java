package commands.math;

import model.Model;
import commands.OneInput;

/**
 * atan operation on one input
 * @author Kevin, Carlos
 *
 */
public class ATan extends OneInput {

	@Override
	public double evaluate(Model model) {
		return Math.atan(getInputValueOne());
	}

}
