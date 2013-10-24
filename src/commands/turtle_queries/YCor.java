package commands.turtle_queries;

import model.Model;
import commands.Command;
import commands.CommandZeroInput;

/**
 * Returns Y coordinate of turtle.
 * @author carlosreyes
 *
 */
public class YCor extends CommandZeroInput {

	@Override
	public double evaluate(Model model) {
		return model.getY();
	}

}
