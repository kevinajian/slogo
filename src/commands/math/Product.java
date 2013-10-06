package commands.math;

import model.Model;
import commands.TwoInput;

/**
 * Takes the product of two values.
 * Ex. 4*2 = 8
 * @author carlosreyes
 *
 */
public class Product extends TwoInput {

	@Override
	public double evaluate(Model model) {
		return getInputValueOne() * getInputValueTwo();
	}

}
