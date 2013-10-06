package commands.math;

import commands.TwoInput;
import model.Model;

/**
 * Takes the product of two values.
 * Ex. 4*2 = 8
 * @author carlosreyes
 *
 */
public class Product extends TwoInput {

	@Override
	public double evaluate() {
		return getInputValueOne() * getInputValueTwo();
	}

}
