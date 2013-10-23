package commands;

import model.Model;

/**
 * Command with no children
 * @author Kevin
 *
 */
public class CommandZeroInput extends Command{

	/**
	 * sets number of inputs to 0
	 */
	public CommandZeroInput() {
		super.myNumInputs = 0;
	}
	
}
