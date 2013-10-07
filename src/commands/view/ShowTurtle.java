package commands.view;

import parser.Constants;
import model.Model;
import commands.Command;

public class ShowTurtle extends Command {

	@Override
	public double evaluate(Model model) {
		model.setTurtleVisible(Constants.TURTLE_SHOWING);
		return 1;
	}
	
}
