package commands.turtle_commands;

import model.Model;
import model.State;
import commands.CommandOneInput;

/**
 * Movement handles making new states when a turtle moves in given
 * direction (forward or backward) and returns the new state of the
 * turtle.
 * @author carlosreyes, kevinjian
 *
 */
public abstract class Movement extends CommandOneInput {

	public State handle(Model model) {
		double orientation = model.getOrientation();
		double x = model.getX();
		double y = model.getY();
		double distance = getInputValueOne(model);
		double angle = Math.toRadians(orientation);		
		double newX = makeX(distance, angle, x);
		double newY = makeY(distance, angle, y);
		String penColor = model.getPenColor();
		return new State(newX, newY, orientation, model.getTurtleVisible(), model.getPenVisible(), penColor);
	}

	protected abstract double makeX(double distance, double angle, double x);
	protected abstract double makeY(double distance, double angle, double y);

}
