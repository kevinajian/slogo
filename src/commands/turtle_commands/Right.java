package commands.turtle_commands;

import model.Constants;
import model.Model;

/**
 * Rotates the turtle left, by shifting the angle
 * by 90 degrees.
 * @author carlosreyes, kevinjian
 *
 */
public class Right extends Direction  {
	
	protected double makeOrientation(double orientation, double firstInput) {
		return (orientation + firstInput)%Constants.DEGREES;
	}
	
	@Override
	public double evaluate(Model model) {
		handle(model);
		return getInputValueOne(model);
	}
	
}
