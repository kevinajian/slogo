package commands.math;

import model.Model;
import commands.Command;

/**
 * Takes the quotient of two values.
 * Ex. 4/2 = 2
 * @author carlosreyes
 *
 */
public class Quotient extends Command {

	@Override
	public double evaluate(Model model) {
		return getInputValueOne() / getInputValueTwo();
	}

}
