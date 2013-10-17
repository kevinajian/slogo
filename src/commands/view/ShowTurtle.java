package commands.view;

import model.Constants;
import model.Model;
import commands.Command;
import commands.CommandZeroInput;

/**
 * Sets the visibility of the turtle to on (1)
 * @author carlosreyes
 *
 */
public class ShowTurtle extends CommandZeroInput {

	@Override
	public double evaluate(Model model) {
		model.setTurtleVisible(Constants.TURTLE_SHOWING);
		return 1;
	}
	
}
