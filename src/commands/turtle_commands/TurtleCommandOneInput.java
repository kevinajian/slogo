package commands.turtle_commands;

import commands.OneInput;

import model.Model;

public class TurtleCommandOneInput extends OneInput {

	@Override
	public double evaluate() {
		getInputValueOne();
		return 0;
	}

	public double operation(Model model) {
		// TODO Auto-generated method stub
		return 0;
	}

}
