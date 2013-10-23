package commands.turtle_commands;

import model.Model;
import model.State;
import commands.CommandOneInput;

public abstract class Direction extends CommandOneInput {
	public void handle(Model model) {
		double orientation = model.getOrientation();
		double firstInput = getInputValueOne(model);
		double newOrientation = makeOrientation(orientation, firstInput);
		String penColor = model.getPenColor();
		model.addState(new State(model.getX(), model.getY(), newOrientation, model.getTurtleVisible(), model.getPenVisible(), penColor));
	}

	protected abstract double makeOrientation(double orientation, double firstInput);
}
