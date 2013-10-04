package commands.turtle_commands.direction;

import model.Model;
import model.State;

import commands.OneInput;

public class Left extends OneInput{
	private static final double RIGHT_ANGLE = 90;

	//TODO this is almost the same as the right command, make a parent class!
	@Override
	public double operation(Model model) {
		double orientation = model.getOrientation();
		double x = model.getX();
		double y = model.getY();
		double distance = getInputValue();
	
		double newX = x + distance*Math.sin(Math.toRadians(orientation) - RIGHT_ANGLE);
		double newY = y + distance*Math.cos(Math.toRadians(orientation) - RIGHT_ANGLE);

		State state = new State(newX, newY, orientation);
		
		model.setState(state);
		
		return getInputValue();
	}
	
}
