package commands.turtle_queries;

import model.Model;
import commands.Command;
import commands.CommandZeroInput;

/**
 * Returns the direction that the turtle is facing in
 * degrees.
 * @author carlosreyes
 */
public class Heading extends CommandZeroInput {

	@Override
	public double evaluate(Model model) {
		return model.getOrientation();
	}
	
}
