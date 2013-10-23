package commands.display_commands;

import model.Model;
import commands.CommandZeroInput;

/**
 * Clears all stamps created by user
 * @author Kevin
 *
 */
public class ClearStamps extends CommandZeroInput {

	/**
	 * Clears stamps held by model
	 */
	@Override
	public double evaluate(Model model) {
		model.clearStamps();
		return 0;
	}	
}
