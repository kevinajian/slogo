package commands.view;

import model.Constants;
import model.Model;
import commands.Command;
import commands.CommandZeroInput;

/**
 * Makes the turtle invisible (0).
 * Returns 0
 * @author carlosreyes
 *
 */
public class HideTurtle extends CommandZeroInput {

	@Override
	public double evaluate(Model model) {
		model.setTurtleVisible(Constants.TURTLE_NOTSHOWING);
		return 0;
	}
	
}
