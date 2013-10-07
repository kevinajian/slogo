package commands.turtle_commands;

import commands.Command;

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
public class Forward extends Command {
	//TODO this is almost the same as the back command, make a parent class!
	@Override
	public double evaluate(Model model) {
		double orientation = model.getOrientation();
		double x = model.getX();
		double y = model.getY();
		double distance = getInputValueOne();
		
		double newX = x + distance*Math.sin(Math.toRadians(orientation));
		double newY = y + distance*Math.cos(Math.toRadians(orientation));
		
		model.addState(new State(newX, newY, orientation, model.getTurtleVisible(), model.getPenVisible()));
		
		return getInputValueOne();
	}

}
