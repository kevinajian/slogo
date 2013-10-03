package commands;

import model.Model;

public interface Command {
	public double operation(Model model);
}
