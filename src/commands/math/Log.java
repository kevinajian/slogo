package commands.math;

import model.Model;
import commands.Command;

/**
 * takes the log of the input value
 * @author Kevin
 *
 */
public class Log extends Command{

	@Override
	public double evaluate(Model model) {
		return Math.log(getInputValueOne());
	}

}
