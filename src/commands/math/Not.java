package commands.math;

import model.Model;
import commands.Command;
import commands.CommandOneInput;

/**
 * Returns 1 if input value is 0
 * else returns 0
 * @author Kevin
 *
 */
public class Not extends CommandOneInput {

	@Override
	public double evaluate(Model model) {
		if (getInputValueOne(model) == 0) {
			return 1;
		}
		return 0;
	}

}
