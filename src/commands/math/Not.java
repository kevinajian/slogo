package commands.math;

import model.Model;
import commands.Command;

/**
 * returns 1 if input value is 0
 * else returns 0
 * @author Kevin
 *
 */
public class Not extends Command {

	@Override
	public double evaluate(Model model) {
		if (getInputValueOne() == 0) {
			return 1;
		}
		return 0;
	}

}
