package commands.turtle_commands;

import commands.CommandOneInput;
import model.Constants;
import model.Model;
import model.State;

/**
 * Turns the turtle to face an absolute degree given.
 * Returns the number of degrees moved.
 * @author carlosreyes
 *
 */
public class SetHeading extends CommandOneInput {

	@Override
	public double evaluate(Model model) {		
		double orientation = model.getOrientation();
		String penColor = model.getPenColor();
		model.addState(new State(model.getX(), model.getY(), getInputValueOne(model)%Constants.DEGREES, model.getTurtleVisible(), model.getPenVisible(), penColor));
		return Math.abs(getInputValueOne(model)%Constants.DEGREES - orientation);
	}

}