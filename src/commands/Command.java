package commands;

import model.Model;

public abstract class Command {
	public abstract double operation(Model model);
	
	Command leftChild;
	Command parent;
}
