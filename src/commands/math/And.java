package commands.math;

import java.util.List;

import model.Model;
import commands.TwoInput;

/**
 * returns 1 if two inputs are not zero
 * else returns 0
 * @author Kevin
 */
public class And extends TwoInput {

	@Override
	public double evaluate() {
		if ((getInputValueTwo() != 0) && (getInputValueOne() != 0)) {
			return 1;
		}
		return 0;
	}
}