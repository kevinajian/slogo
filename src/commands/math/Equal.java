package commands.math;

import model.Model;
import commands.Command;

/**
 * Checks if two primitive values are equal
 * @author Kevin
 *
 */
public class Equal extends Command{
	@Override
	public double evaluate(Model model){
		if (getInputValueOne() == getInputValueTwo()) {
			return 1;
		}
		return 0;
	}
}
