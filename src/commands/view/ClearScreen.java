package commands.view;

import commands.Command;
import commands.CommandZeroInput;
import model.Constants;
import model.Model;
import model.State;

/**
 * Clears the view of the turtle's trail and resets the turtle to
 * its home position of 0,0 and returns the direction its facing
 * to default.
 * @author carlosreyes
 *
 */
public class ClearScreen extends CommandZeroInput {
	
	@Override
	public double evaluate(Model model) {
		System.out.println("hello");
		double x = model.getX();
		double y = model.getY();
		model.getStates().clear();
		
		State current = model.getCurrentState();
		System.out.println("x: "+current.getX() + " y: " + current.getY());
		
		
		model.addState(new State(Constants.TURTLE_XORIGIN, Constants.TURTLE_YORIGIN, Constants.TURTLE_DEGREEORIGIN, model.getTurtleVisible(), model.getPenVisible()));
		return calculateLength(x, y, Constants.TURTLE_XORIGIN, Constants.TURTLE_YORIGIN);
	}
	
	/**
	 * Uses pythagorean theorem to find the distance between the turtles previous point
	 * and the point 0,0 where it moves to.
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
