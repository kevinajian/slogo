package commands.turtle_commands;

import parser.Constants;
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
		double calculation = Math.toDegrees(Math.atan(newX / newY));
		double newOrientation;
		if (newX > 0) {
			newOrientation = Constants.RIGHT_ANGLE - calculation;
		}
		else if (newX < 0) {
			newOrientation = Constants.LEFT_ANGLE - calculation;
		}
		else
			newOrientation = 0;
		
		model.addState(new State(x, y, newOrientation, model.getTurtleVisible(), model.getPenVisible()));
		
		return Math.abs(orientation-newOrientation);
	}

}