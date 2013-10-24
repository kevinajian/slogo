package commands.math;

import model.Model;
import commands.Command;

/**
 * Returns 1 if the first input is less than the second input
 * else returns 0
 * @author Kevin, Carlos
 *
 */
public class Less extends Command {

	@Override
	public double evaluate(Model model) {
		if (getInputValueOne(model) < getInputValueTwo(model)) {
			return 1;
		}
		return 0;
	}
	
}
