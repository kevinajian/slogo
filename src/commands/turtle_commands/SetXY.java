package commands.turtle_commands;

import model.Model;
import model.State;
import commands.Command;

/**
 * Moves the turtle to a given set of coordinates x,y 
 * on the screen.
 * Returns the distance that the turtle moved.
 * @author carlosreyes
 *
 */
public class SetXY extends Command{

	@Override
	public double evaluate(Model model) {
		double x = model.getX();
		double y = model.getY();
		String penColor = model.getPenColor();
		model.addState(new State(getInputValueOne(model), getInputValueTwo(model), model.getOrientation(), model.getTurtleVisible(), model.getPenVisible(), penColor));
		return calculateLength(x, y, getInputValueOne(model), getInputValueTwo(model));
	}
	
	/**
	 * Uses the pythagorean theorem to calculate the distance that the turtle moved
	 * by finding the length of the hypotenuse of the triangle formed by the two sets
	 * of coordinates.
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return
	 */
	private double calculateLength(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)); 
	}

}
