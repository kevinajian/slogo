package commands;

/**
 * Command with only one child
 * @author Kevin
 *
 */
public abstract class CommandOneInput extends Command {
	
	/**
	 * sets number of inputs to 1
	 */
	public CommandOneInput() {
		super.myNumInputs = 1;
	}
	
}