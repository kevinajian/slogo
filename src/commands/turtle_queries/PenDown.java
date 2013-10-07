package commands.turtle_queries;

import parser.Constants;
import model.Model;
import commands.Command;

public class PenDown extends Command{

	@Override
	public double evaluate(Model model) {
		if (model.getPenVisible().equals(Constants.PEN_SHOWING)) {
			return 1;
		}
		return 0;
	}

}
