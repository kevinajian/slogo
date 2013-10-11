package commands.view;

import parser.Constants;
import model.Model;
import commands.Command;

/**
 * Sets the pen position to down (1) so that the turtle can
 * draw lines as it moves.
 * Returns 1
 * @author carlosreyes
 *
 */
public class SetPenDown extends Command {

	@Override
	public double evaluate(Model model) {
		model.setPenVisible(Constants.PEN_SHOWING);
		return 1;
	}

}
