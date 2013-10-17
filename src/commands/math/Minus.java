package commands.math;

import model.Model;
import commands.Command;
import commands.CommandOneInput;

/**
 * Returns negative of input value
 * @author Kevin
 *
 */
public class Minus extends CommandOneInput{

	@Override
	public double evaluate(Model model) {
		return -getInputValueOne();
	}

}
