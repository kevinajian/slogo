package commands.math;

import model.Model;
import commands.Command;

/**
 * Returns power of input value
 * @author Kevin
 *
 */
public class Power extends Command{

	@Override
	public double evaluate(Model model) {
		return Math.pow(getInputValueOne(), getInputValueTwo());
	}

}
