package commands.math;

import model.Model;
import commands.Command;
import commands.CommandOneInput;

/**
 * Atan operation on one input
 * @author Kevin, Carlos
 *
 */
public class ATan extends CommandOneInput {

	@Override
	public double evaluate(Model model) {
		return Math.atan(getInputValueOne(model));
	}

}
