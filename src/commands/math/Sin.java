package commands.math;

import model.Model;
import commands.Command;

/**
 * Returns sin of input value
 * @author Kevin, Carlos
 *
 */
public class Sin extends Command{

	@Override
	public double evaluate(Model model) {
		return Math.sin(Math.toRadians(getInputValueOne()));
	}

}
