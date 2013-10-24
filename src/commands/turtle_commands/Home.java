package commands.turtle_commands;

import commands.CommandZeroInput;
import model.Constants;
import model.Model;
import model.State;
import utilities.Utilities;

/**
 * Returns the turtle to the 0,0 coordinate (center of the grid)
 * and resets the orientation of the turtle to the default orientation.
 * Returns the distance that the turtle moved to get to the origin.
 * @author carlosreyes, kevinjian
 *
 */
public class Home extends CommandZeroInput {
	
	@Override
	public double evaluate(Model model) {
		double x = model.getX();
		double y = model.getY();
		String penColor = model.getPenColor();
		model.addState(new State(Constants.TURTLE_XORIGIN, Constants.TURTLE_YORIGIN, Constants.TURTLE_DEGREEORIGIN, model.getTurtleVisible(), model.getPenVisible(), penColor));
		return Utilities.calculateLength(x, y, Constants.TURTLE_XORIGIN, Constants.TURTLE_YORIGIN);
	}
}