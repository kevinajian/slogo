package commands.turtle_commands.direction;

import commands.Command;
import model.Model;
import model.State;

public class Home implements Command {
	
	@Override
	public double operation(Model model) {
		double x = model.getX();
		double y = model.getY();
		
		model.addState(new State(0, 0, model.getOrientation()));
		return calculateLength(x, y, 0, 0);
	}
	
	private double calculateLength(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)); 
	}
}
