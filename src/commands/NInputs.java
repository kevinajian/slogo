package commands;

import model.Model;

/**
 * Command that takes in n parameters
 * Has a String for command name
 * @author Kevin, Carlos
 *
 */
public class NInputs extends Command{
	private String myCommandName;
	
	/**
	 * constructor, sets number of parameters
	 * @param numParams - Number of parameters
	 * @param numCommands - Number of commands
	 */
	public NInputs(String commandName, int numParams, int numCommands){
		myCommandName = commandName;
		myNumInputs = numCommands;
	}

	@Override
	public double evaluate(Model model) {
		return 0;
	}
}