package commands.view;

import model.Constants;
import model.Model;
import model.State;
import commands.Command;
import commands.CommandZeroInput;

/**
 * Makes the turtle invisible (0).
 * Returns 0
 * @author carlosreyes, kevin
 *
 */
public class HideTurtle extends CommandZeroInput {

	@Override
	public double evaluate(Model model) {
		model.setTurtleVisible(Constants.TURTLE_NOTSHOWING);
		State newState = model.getCurrentState();
		newState.setTurtleVisible(model.getTurtleVisible());
		model.addState(newState);
		return 0;
	}
}
