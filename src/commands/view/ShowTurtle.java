package commands.view;

import model.Constants;
import model.Model;
import model.State;
import commands.Command;
import commands.CommandZeroInput;

/**
 * Sets the visibility of the turtle to on (1)
 * @author carlosreyes, kevin
 *
 */
public class ShowTurtle extends CommandZeroInput {

	@Override
	public double evaluate(Model model) {
		model.setTurtleVisible(Constants.TURTLE_SHOWING);
		State newState = model.getCurrentState();
		newState.setTurtleVisible(model.getTurtleVisible());
		model.addState(newState);
		return 1;
	}
	
}
