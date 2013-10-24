package commands.math;

import model.Model;
import commands.Command;

/**
 * Returns the remainder of division
 * @author Kevin, Carlos
 */
public class Remainder extends Command {

	@Override
	public double evaluate(Model model) {
		return getInputValueOne(model) % getInputValueTwo(model);
	}

	
}
