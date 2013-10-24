package commands.math;

import model.Model;
import commands.Command;
import commands.CommandOneInput;

/**
 * returns Random number less than input
 * @author Kevin
 *
 */
public class Random extends CommandOneInput {

	@Override
	public double evaluate(Model model) {
		return Math.random()*getInputValueOne(model);
	}

}
