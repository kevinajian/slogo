package commands.math;

import model.Model;
import commands.Command;

/**
 * cos operation on one input
 * @author Kevin, Carlos
 *
 */
public class Cos extends Command{
	private int myNumInputs = 1;
	
	@Override
	public double evaluate(Model model) {
		return Math.cos(Math.toRadians(getInputValueOne()));
	}

}
