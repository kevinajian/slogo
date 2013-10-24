package commands.turtle_commands;

import model.Model;

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
public class Back extends Movement {
	
	public double makeX(double distance, double angle, double x){ 
		return x - distance*Math.sin(angle);
	}
	public double makeY(double distance, double angle, double y){ 
		return y - distance*Math.cos(angle);
	}
	
	@Override
	public double evaluate(Model model) {
		model.addState(handle(model));
		return getInputValueOne(model);
	}
	
}

