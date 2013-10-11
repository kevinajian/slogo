package commands.turtle_queries;

import parser.Constants;
import model.Model;
import commands.Command;

/**
 * Returns 1 if the turtle is showing.
 * Returns 0 otherwise.
 * @author carlosreyes
 *
 */
public class Showing extends Command {

	@Override
	public double evaluate(Model model) {
		if (model.getTurtleVisible().equals(Constants.TURTLE_SHOWING)) {
			return 1;
		}
		return 0;
	}

}
