package commands.math;

import model.Model;
import commands.Command;

/**
 * Takes the difference of two values.
 * Ex. 4-2 = 2
 * @author carlosreyes
 *
 */
public class Difference extends MathTwoInput {

	@Override
	public double evaluate(Math model) {
		return getInputValueOne() - getInputValueTwo();
	}

}