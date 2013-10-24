package commands.turtle_commands;

import utilities.Utilities;
import model.Model;
import model.State;
import commands.Command;

/**
 * Moves the turtle to a given set of coordinates x,y 
 * on the screen.
 * Returns the distance that the turtle moved.
 * @author carlosreyes
 *
 */
public class SetXY extends Command{

	@Override
	public double evaluate(Model model) {
		double x = model.getX();
		double y = model.getY();
		String penColor = model.getPenColor();
		model.addState(new State(getInputValueOne(model), getInputValueTwo(model), model.getOrientation(), model.getTurtleVisible(), model.getPenVisible(), penColor));
		return Utilities.calculateLength(x, y, getInputValueOne(model), getInputValueTwo(model));
	}

}
