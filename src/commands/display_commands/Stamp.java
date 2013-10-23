package commands.display_commands;

import model.Model;
import commands.CommandZeroInput;

/**
 * Stamp command to add stamps
 * @author Kevin
 *
 */
public class Stamp extends CommandZeroInput {
	
	/**
	 * Adds current state of turtle to model as stamp
	 */
	@Override
	public double evaluate(Model model) {
		model.addStamp(model.getCurrentState());
		return 0;
	}	
}
