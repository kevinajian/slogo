package commands.math;

import model.Model;
import commands.Command;

/**
 * atan operation on one input
 * @author Kevin, Carlos
 *
 */
public class ATan extends Command {

	@Override
	public double evaluate(Model model) {
		return Math.atan(getInputValueOne());
	}

}
