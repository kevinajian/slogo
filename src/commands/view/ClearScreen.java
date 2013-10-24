package commands.view;

import utilities.Utilities;
import commands.CommandZeroInput;
import model.Constants;
import model.Model;
import model.State;

/**
 * Clears the view of the turtle's trail and resets the turtle to
 * its home position of 0,0 and returns the direction its facing
 * to default.
 * @author carlosreyes, kevin
 *
 */
public class ClearScreen extends CommandZeroInput {
	
	@Override
	public double evaluate(Model model) {
		double x = model.getX();
		double y = model.getY();
		String penColor = model.getPenColor();
		model.getStates().clear();
		model.addState(new State(Constants.TURTLE_XORIGIN, Constants.TURTLE_YORIGIN, Constants.TURTLE_DEGREEORIGIN, model.getTurtleVisible(), model.getPenVisible(), penColor));

		return Utilities.calculateLength(x, y, Constants.TURTLE_XORIGIN, Constants.TURTLE_YORIGIN);
	}
}
