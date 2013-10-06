package commands.math;

import model.Model;
import commands.OneInput;

/**
 * takes the log of the input value
 * @author Kevin
 *
 */
public class Log extends OneInput{

	@Override
	public double evaluate(Model model) {
		return Math.log(getInputValueOne());
	}

}
