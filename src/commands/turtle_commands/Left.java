package commands.turtle_commands;

import model.Model;
import model.State;

/**
 * Rotates the turtle left, by shifting the angle
 * by -90 degrees.
 * @author carlosreyes
 *
 */
public class Left extends TurtleCommandOneInput{
	private static final double LEFT_ANGLE = -90;

	@Override
	public double operation(Model model) {
		double orientation = model.getOrientation();
		double newOrientation = orientation + LEFT_ANGLE;
		
		model.addState(new State(model.getX(), model.getY(), newOrientation));
		
		return getInputValueOne();
	}

	@Override
	public double evaluate() {
		return getInputValueOne();
	}
	
}
