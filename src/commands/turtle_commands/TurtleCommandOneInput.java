package commands.turtle_commands;

import model.Model;
import model.TurtleCommands;
import commands.Command;

public abstract class TurtleCommandOneInput extends Command {
	@Override
	public abstract double evaluate(Model model);
}
