package commands.math;

import model.Model;
import commands.Command;

/**
 * returns random number less than input
 * @author Kevin
 *
 */
public class Random extends Command {

	@Override
	public double evaluate(Model model) {
		return Math.random()*getInputValueOne();
	}

}
