package commands.turtle_queries;

import model.Model;
import commands.Command;

/**
 * Determines whether the pen is up (0)
 * or down (1)
 * @author carlosreyes
 *
 */
public class PenDown implements Command{

	@Override
	public double operation(Model model) {
		return model.getPenState();
	}

}
