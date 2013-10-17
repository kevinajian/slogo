package commands.turtle_commands;

import model.TurtleCommands;
import commands.Command;

public abstract class TurtleCommandOneInput extends Command {
	public abstract double evaluate(TurtleCommands model);
}
