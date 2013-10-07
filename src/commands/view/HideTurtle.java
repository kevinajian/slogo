package commands.view;

import parser.Constants;
import model.Model;
import commands.Command;

public class HideTurtle extends Command {

	@Override
	public double evaluate(Model model) {
		model.setTurtleVisible(Constants.TURTLE_NOTSHOWING);
		return 0;
	}
	
}
