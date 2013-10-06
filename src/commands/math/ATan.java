package commands.math;

import java.util.List;

import commands.OneInput;
import model.Model;

/**
 * atan operation on one input
 * @author Kevin
 *
 */
public class ATan extends OneInput {

	@Override
	public double evaluate() {
		return Math.atan(getInputValueOne());
	}

}
