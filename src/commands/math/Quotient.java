package commands.math;

import model.Model;
import commands.Command;

/**
 * Takes the quotient of two values.
 * Ex. 4/2 = 2
 * @author carlosreyes
 *
 */
public class Quotient extends MathTwoInput {

	@Override
	public double evaluate(Math model) {
		return getInputValueOne() / getInputValueTwo();
	}

}
