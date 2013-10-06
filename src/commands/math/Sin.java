package commands.math;

import model.Model;
import commands.OneInput;

/**
 * returns sin of input value
 * @author Kevin, Carlos
 *
 */
public class Sin extends OneInput{

	@Override
	public double evaluate(Model model) {
		return Math.sin(Math.toRadians(getInputValueOne()));
	}

}
