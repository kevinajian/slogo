package commands.math;

import model.Model;
import commands.Command;

/**
 * Takes the product of two values.
 * Ex. 4*2 = 8
 * @author carlosreyes
 *
 */
public class Product extends MathTwoInput {

	@Override
	public double evaluate(Math model) {
		return getInputValueOne() * getInputValueTwo();
	}

}
