package commands;

import java.util.List;

import model.Model;

public abstract class CommandList extends Command {
	protected List<Command> myCommandList;
	
	public void setCommandList(List<Command> commandList) {
		myCommandList = commandList;
	}

	public List<Command> getCommandList() {
		return myCommandList;
	}
}
