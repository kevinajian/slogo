package commands.turtle_queries;

import model.Constants;
import model.Model;
import commands.Command;
import commands.CommandZeroInput;

/**
 * Returns 1 if the turtle's pen in down.
 * Returns 0 if its up.
 * @author carlosreyes, kevin
 *
 */
public class PenDown extends CommandZeroInput {

	@Override
	public double evaluate(Model model) {
		if (model.getPenVisible().equals(Constants.PEN_SHOWING)) {
			return 1;
		}
		return 0;
	}

}
