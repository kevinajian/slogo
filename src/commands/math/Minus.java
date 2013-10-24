package commands.math;

import model.Model;
import commands.Command;
import commands.CommandOneInput;

/**
 * Returns negative of input value
 * @author Kevin, Carlos
 *
 */
public class Minus extends CommandOneInput{

	@Override
	public double evaluate(Model model) {
		return -getInputValueOne(model);
	}

}
