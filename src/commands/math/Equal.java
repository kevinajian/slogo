package commands.math;

import model.Model;
import commands.Command;

/**
 * Checks if two primitive values are equal
 * @author Kevin
 *
 */
public class Equal extends MathTwoInput {
	@Override
	public double evaluate(Math model){
		if (getInputValueOne() == getInputValueTwo()) {
			return 1;
		}
		return 0;
	}
}
