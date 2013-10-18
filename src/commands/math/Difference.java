package commands.math;

import model.Model;
import commands.Command;

/**
 * Takes the difference of two values.
 * Ex. 4-2 = 2
 * @author carlosreyes
 *
 */
public class Difference extends Command {

	@Override
	public double evaluate(Model model) {
		return getInputValueOne(model) - getInputValueTwo(model);
	}

}