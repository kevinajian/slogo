package commands.turtle_queries;

import model.Model;
import commands.Command;

public class Heading implements Command {

	@Override
	public double operation(Model model) {
		return model.getOrientation();
	}
	
}
