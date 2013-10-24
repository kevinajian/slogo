package commands.turtle_queries;

import model.Model;
import commands.Command;
import commands.CommandZeroInput;

/**
 * Returns the X Coordinate of the turtle
 * @author carlosreyes
 *
 */
public class XCor extends CommandZeroInput {

	@Override
	public double evaluate(Model model) {
		return model.getX();
	}

}
