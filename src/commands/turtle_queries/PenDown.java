package commands.turtle_queries;

import parser.Constants;
import model.Model;
import commands.Command;

/**
 * Returns 1 if the turtle's pen in down.
 * Returns 0 if its up.
 * @author carlosreyes
 *
 */
public class PenDown extends Command{

	@Override
	public double evaluate(Model model) {
		if (model.getPenVisible().equals(Constants.PEN_SHOWING)) {
			return 1;
		}
		return 0;
	}

}
