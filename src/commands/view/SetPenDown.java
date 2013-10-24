package commands.view;

import model.Constants;
import model.Model;
import commands.Command;
import commands.CommandZeroInput;

/**
 * Sets the pen position to down (1) so that the turtle can
 * draw lines as it moves.
 * Returns 1
 * @author carlosreyes, kevin
 *
 */
public class SetPenDown extends CommandZeroInput {

	@Override
	public double evaluate(Model model) {
		model.setPenVisible(Constants.PEN_SHOWING);
		return 1;
	}

}
