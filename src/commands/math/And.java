package commands.math;

import model.Model;
import commands.Command;

/**
 * Returns 1 if two inputs are not zero
 * else returns 0
 * @author Kevin
 */
public class And extends Command {

	@Override
	public double evaluate(Model model) {
		if ((getInputValueTwo(model) != 0) && (getInputValueOne(model) != 0)) {
			return 1;
		}
		return 0;
	}
}