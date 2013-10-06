package commands.math;

import model.Model;
import commands.TwoInput;

/**
 * Returns the remainder of division
 * @author Kevin
 */
public class Remainder extends TwoInput {

	@Override
	public double evaluate() {
		return getInputValueOne() % getInputValueTwo();
	}

	
}
