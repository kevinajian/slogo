package commands.turtle_commands;

import commands.Command;
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
		model.addState(new State(model.getX(), model.getY(), getInputValueOne()%Constants.DEGREES, model.getTurtleVisible(), model.getPenVisible()));
		return Math.abs(getInputValueOne()%Constants.DEGREES - orientation);
	}

}