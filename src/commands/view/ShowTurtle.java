package commands.view;

import parser.Constants;
import model.Model;
import commands.Command;

/**
 * Sets the visibility of the turtle to on (1)
 * @author carlosreyes
 *
 */
public class ShowTurtle extends Command {

	@Override
	public double evaluate(Model model) {
		model.setTurtleVisible(Constants.TURTLE_SHOWING);
		return 1;
	}
	
}
