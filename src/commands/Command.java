package commands;

import model.Model;

public abstract class Command {
	public abstract double operation(Model model);
	
	Command leftChild;
	Command parent;
	protected int numParams = 0;
	
	public int getNumInputs(){
		return numParams;
	}
}
