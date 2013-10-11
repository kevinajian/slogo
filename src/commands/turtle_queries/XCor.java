package commands.turtle_queries;

import model.Model;
import commands.Command;

/**
 * Returns the X Coordinate of the turtle
 * @author carlosreyes
 *
 */
public class XCor extends Command {

	@Override
	public double evaluate(Model model) {
		return model.getX();
	}

}
