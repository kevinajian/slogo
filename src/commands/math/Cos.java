package commands.math;

import model.Model;
import commands.OneInput;

/**
 * cos operation on one input
 * @author Kevin, Carlos
 *
 */
public class Cos extends OneInput{

	@Override
	public double evaluate(Model model) {
		return Math.cos(Math.toRadians(getInputValueOne()));
	}

}
