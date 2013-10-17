package commands.math;

import model.Model;
import commands.Command;
import commands.CommandOneInput;

/**
 * Returns tan of input value
 * @author Kevin, Carlos
 *
 */
public class Tan extends CommandOneInput {

	@Override
	public double evaluate(Model model) {
		return Math.tan(Math.toRadians(getInputValueOne()));
	}

}
