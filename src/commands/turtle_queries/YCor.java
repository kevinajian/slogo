package commands.turtle_queries;

import model.Model;
import commands.Command;

/**
 * Returns Y coordinate of turtle.
 * @author carlosreyes
 *
 */
public class YCor extends Command {

	@Override
	public double evaluate(Model model) {
		return model.getY();
	}

}
