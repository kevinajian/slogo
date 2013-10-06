package commands.math;

import commands.OneInput;
import model.Model;

/**
 * returns sin of input value
 * @author Kevin
 *
 */
public class Sin extends OneInput{

	@Override
	public double evaluate() {
		return Math.sin(getInputValueOne());
	}

}
