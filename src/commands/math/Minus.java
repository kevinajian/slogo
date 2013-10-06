package commands.math;

import commands.OneInput;
import model.Model;

/**
 * returns negative of input value
 * @author Kevin
 *
 */
public class Minus extends OneInput{

	@Override
	public double evaluate() {
		return -getInputValueOne();
	}

}
