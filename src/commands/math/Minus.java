package commands.math;

import model.Model;
import commands.OneInput;

/**
 * returns negative of input value
 * @author Kevin
 *
 */
public class Minus extends OneInput{

	@Override
	public double evaluate(Model model) {
		return -getInputValueOne();
	}

}
