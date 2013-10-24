package commands.math;

import model.Model;
import commands.Command;
import commands.CommandOneInput;

/**
 * Takes the log of the input value
 * @author Kevin, Carlos
 *
 */
public class Log extends CommandOneInput {

	@Override
	public double evaluate(Model model) {
		return Math.log(getInputValueOne(model));
	}

}
