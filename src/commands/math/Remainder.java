package commands.math;

import model.Model;
import commands.Command;

/**
 * Returns the remainder of division
 * @author Kevin
 */
public class Remainder extends MathTwoInput {

	@Override
	public double evaluate(Math model) {
		return getInputValueOne() % getInputValueTwo();
	}

	
}
