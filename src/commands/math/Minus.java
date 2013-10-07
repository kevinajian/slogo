package commands.math;

import model.Model;
import commands.Command;

/**
 * returns negative of input value
 * @author Kevin
 *
 */
public class Minus extends Command{

	@Override
	public double evaluate(Model model) {
		return -getInputValueOne();
	}

}
