package commands.math;

import model.Model;
import commands.Command;

/**
 * Returns the remainder of division
 * @author Kevin
 */
public class Remainder extends Command {

	@Override
	public double evaluate(Model model) {
		return getInputValueOne() % getInputValueTwo();
	}

	
}
