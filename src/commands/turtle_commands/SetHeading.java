package commands.turtle_commands;

import model.Model;
import model.State;
import commands.OneInput;

public class SetHeading extends OneInput {

	@Override
	public double operation(Model model) {		
		model.addState(new State(model.getX(), model.getY(), getInputValue()));
		return Math.abs(getInputValue() - model.getOrientation());
		
	}
	
}