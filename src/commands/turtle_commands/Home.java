package commands.turtle_commands;

import parser.Constants;
import commands.Command;
import commands.CommandZeroInput;
import model.Model;
import model.State;

/**
 * Returns the turtle to the 0,0 coordinate (center of the grid)
 * and resets the orientation of the turtle to the default orientation.
 * Returns the distance that the turtle moved to get to the origin.
 * @author carlosreyes
 *
 */
public class Home extends CommandZeroInput {
	
	@Override
	public double evaluate(Model model) {
		double x = model.getX();
		double y = model.getY();
		model.addState(new State(Constants.TURTLE_XORIGIN, Constants.TURTLE_YORIGIN, Constants.TURTLE_DEGREEORIGIN, model.getTurtleVisible(), model.getPenVisible()));
		return calculateLength(x, y, Constants.TURTLE_XORIGIN, Constants.TURTLE_YORIGIN);
	}
	
	private double calculateLength(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)); 
	}

}
