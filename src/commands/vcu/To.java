package commands.vcu;

import java.util.List;

import commands.Command;

/**
 * Assigns commands given in the second list to commandName using parameters given in first list as variables
 * When commandName is used later in a program, any given values are assigned to variables that can be accessed when the command list is run
 * Returns 1 if command is successfully defined, otherwise 0
 * @author carlosreyes
 *
 */
public class To extends IfElse {
	private String myName;
	private List<String> myParameters;
	private List<Command> myCommandList;

	public String getName() {
		return myName;
	}

	public void setName(String myName) {
		this.myName = myName;
	}

	public List<String> getParameters() {
		return myParameters;
	}

	public void setParameters(List<String> myParameters) {
		this.myParameters = myParameters;
	}

	public List<Command> getCommandList() {
		return myCommandList;
	}

	public void setCommandList(List<Command> myCommands) {
		this.myCommandList = myCommands;
	}

}
