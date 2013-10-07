package commands.turtle_commands;

import parser.Constants;
import commands.OneInput;
import model.Model;
import model.State;

public class SetHeading extends OneInput {

	@Override
	public double evaluate(Model model) {		
		double orientation = model.getOrientation();
		model.addState(new State(model.getX(), model.getY(), getInputValueOne()%Constants.DEGREES, model.getTurtleVisible(), model.getPenVisible()));
		return Math.abs(getInputValueOne()%Constants.DEGREES - orientation);
	}

}