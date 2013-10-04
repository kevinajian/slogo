package commands.turtle_commands.direction;

import model.Model;
import model.State;

import commands.OneInput;

public class Right extends OneInput{
	private static final double RIGHT_ANGLE = 90;

	//TODO this is almost the same as the left command, make a parent class!
	@Override
	public double operation(Model model) {
		double orientation = model.getOrientation();
		double x = model.getX();
		double y = model.getY();
		double distance = getInputValue();
	
		double newX = x + distance*Math.sin(RIGHT_ANGLE + Math.toRadians(orientation));
		double newY = y + distance*Math.cos(RIGHT_ANGLE + Math.toRadians(orientation));

		State state = new State(newX, newY, orientation);
		
		model.setState(state);
		
		return getInputValue();
	}
	
}
