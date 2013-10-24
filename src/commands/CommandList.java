package commands;

import java.util.List;

import model.Model;

/**
 * Extention of command, adds a list of commands
 * @author Kevin
 *
 */
public abstract class CommandList extends Command {
	protected List<Command> myCommandList;
	
	/**
	 * sets command list
	 * @param commandList - command list to be set
	 */
	public void setCommandList(List<Command> commandList) {
		myCommandList = commandList;
	}

	/**
	 * returns command list
	 * @return - List of Commands
	 */
	public List<Command> getCommandList() {
		return myCommandList;
	}
}