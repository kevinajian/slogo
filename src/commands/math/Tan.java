package commands.math;

import model.Model;
import commands.Command;

/**
 * Returns tan of input value
 * @author Kevin, Carlos
 *
 */
public class Tan extends Command {

	@Override
	public double evaluate(Model model) {
		return Math.tan(Math.toRadians(getInputValueOne()));
	}

}
