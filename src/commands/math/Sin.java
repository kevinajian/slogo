package commands.math;

import model.Model;
import commands.Command;
import commands.CommandOneInput;

/**
 * Returns sin of input value
 * @author Kevin, Carlos
 *
 */
public class Sin extends CommandOneInput {

	@Override
	public double evaluate(Model model) {
		return Math.sin(Math.toRadians(getInputValueOne()));
	}

}
