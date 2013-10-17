package commands.turtle_commands;

import commands.Command;
import commands.CommandOneInput;
import model.Constants;
import model.Model;
import model.State;

/**
 * Rotates the turtle left, by shifting the angle
 * by 90 degrees.
 * @author carlosreyes
 *
 */
public class Right extends CommandOneInput  {

	@Override
	public double evaluate(Model model) {
		double orientation = model.getOrientation();
		double newOrientation = (orientation + getInputValueOne())%Constants.DEGREES;
		
		model.addState(new State(model.getX(), model.getY(), newOrientation, model.getTurtleVisible(), model.getPenVisible()));
		
		return getInputValueOne();
	}
	
}
