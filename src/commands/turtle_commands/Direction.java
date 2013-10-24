package commands.turtle_commands;

import model.Model;
import model.State;
import commands.CommandOneInput;
/**
 * Direction handles making new states, when a turtle's degree is shifted
 * makeOrienatation must be implemented depending on the direction in which
 * one would like to rotate.
 * @author carlosreyes
 *
 */
public abstract class Direction extends CommandOneInput {
	public void handle(Model model) {
		double orientation = model.getOrientation();
		double firstInput = getInputValueOne(model);
		double newOrientation = makeOrientation(orientation, firstInput);
		String penColor = model.getPenColor();
		model.addState(new State(model.getX(), model.getY(), newOrientation, model.getTurtleVisible(), model.getPenVisible(), penColor));
	}
	
	/**
	 * Determines direction in which turtle rotates.
	 * @param orientation
	 * @param firstInput
	 * @return
	 */
	protected abstract double makeOrientation(double orientation, double firstInput);
}
