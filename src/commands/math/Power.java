package commands.math;

import model.Model;
import commands.OneInput;

/**
 * returns power of input value
 * @author Kevin
 *
 */
public class Power extends OneInput{

	@Override
	public double evaluate(Model model) {
		//FIX THIS
		return Math.pow(getInputValueOne(), 0);
	}

}
