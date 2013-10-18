package commands.math;

import model.Model;
import commands.Command;

/**
 * Takes the sum of two values.
 * Ex. 4+2 = 6
 * @author carlosreyes
 *
 */
public class Sum extends Command {
	
	@Override
	public double evaluate(Model model) {
		return super.getInputValueOne(model) + getInputValueTwo(model);
	}
}
