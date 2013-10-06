package commands.turtle_commands;

import commands.OneInput;

import model.Model;
import model.State;

public class SetHeading extends OneInput {

	@Override
	public double evaluate(Model model) {		
		model.addState(new State(model.getX(), model.getY(), getInputValueOne()));
		return Math.abs(getInputValueOne() - model.getOrientation());
		
	}

}