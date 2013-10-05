package commands.turtle_commands.degree;

import model.Model;
import commands.TwoInput;

public class Towards extends TwoInput{

	@Override
	public double operation(Model model) {
		double orientation = model.getOrientation();
		double x = model.getX();
		double y = model.getY();
		double directionX = getInputValueOne();
		double directionY = getInputValueTwo();
		
		double newOrientation = Math.atan((directionY-y)/(directionX-x));
		
		return Math.abs(orientation-newOrientation);
	}

}
