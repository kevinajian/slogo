package commands.view;

import parser.Constants;
import model.Model;
import commands.Command;

/**
 * Makes the turtle invisible (0).
 * Returns 0
 * @author carlosreyes
 *
 */
public class HideTurtle extends Command {

	@Override
	public double evaluate(Model model) {
		model.setTurtleVisible(Constants.TURTLE_NOTSHOWING);
		return 0;
	}
	
}
