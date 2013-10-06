package commands.turtle_queries;

import model.Model;
import commands.Command;

public class Heading extends Command {

	@Override
	public double evaluate(Model model) {
		return model.getOrientation();
	}
	
}
