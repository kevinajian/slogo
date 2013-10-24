package commands.math;

import model.Model;
import commands.Command;
import commands.CommandOneInput;

/**
 * cos operation on one input
 * @author Kevin, Carlos
 *
 */
public class Cos extends CommandOneInput {

	@Override
	public double evaluate(Model model) {
		return Math.cos(Math.toRadians(getInputValueOne(model)));
	}

}
