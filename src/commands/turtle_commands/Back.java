package commands.turtle_commands;

import commands.CommandOneInput;
import model.Model;
import model.State;

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
public class Back extends CommandOneInput {
	@Override
	public double evaluate(Model model) {
		double orientation = model.getOrientation();
		double x = model.getX();
		double y = model.getY();
		double distance = getInputValueOne(model);
		
		double newX = x - distance*Math.sin(Math.toRadians(orientation));
		double newY = y - distance*Math.cos(Math.toRadians(orientation));
		String penColor = model.getPenColor();
		model.addState(new State(newX, newY, orientation, model.getTurtleVisible(), model.getPenVisible(), penColor));
		
		return getInputValueOne(model);
	}
	
}

