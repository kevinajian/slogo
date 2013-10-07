package commands.turtle_commands;

import model.Model;
import model.State;
import commands.TwoInput;

public class Towards extends TwoInput{

	@Override
	public double evaluate(Model model) {
		double orientation = model.getOrientation();
		double x = model.getX();
		double y = model.getY();
		double directionX = getInputValueOne();
		double directionY = getInputValueTwo();
		double newX = directionX - x;
		double newY = directionY - y;
		
		
		double newOrientation = Math.atan((directionY-y)/(directionX-x));
		model.addState(new State(x, y, newOrientation, model.getTurtleVisible(), model.getPenVisible()));
		
		return Math.toDegrees(Math.abs(orientation-newOrientation));
	}

}
