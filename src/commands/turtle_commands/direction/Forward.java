package commands.turtle_commands.direction;

import model.Model;
import model.State;
import commands.OneInput;

/**
 * Takes input pixels, changes x or y values based on
 * the angle orientation of the turtle.
 * Takes the orientation stored the model and uses the
 * orientation class to determine where to update the x and y
 * coordinates to using sin and cos. Angle starts at upper
 * y-axis.
 * @author carlosreyes
 *
 */
public class Forward extends OneInput{
	//TODO this is almost the same as the back command, make a parent class!
	@Override
	public double operation(Model model) {
		double orientation = model.getOrientation();
		double x = model.getX();
		double y = model.getY();
		double distance = getInputValue();
	
		double newX = x + distance*Math.sin(Math.toRadians(orientation));
		double newY = y + distance*Math.cos(Math.toRadians(orientation));

		State state = new State(newX, newY, orientation);
		
		model.setState(state);
		
		return getInputValue();
	}
	
}
