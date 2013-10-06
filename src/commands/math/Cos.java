package commands.math;

import java.util.List;

import commands.OneInput;
import model.Model;

/**
 * cos operation on one input
 * @author Kevin
 *
 */
public class Cos extends OneInput{

	@Override
	public double evaluate() {
		return Math.cos(getInputValueOne());
	}

}
