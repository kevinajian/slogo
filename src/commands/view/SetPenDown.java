package commands.view;

import parser.Constants;
import model.Model;
import commands.Command;

public class SetPenDown extends Command {

	@Override
	public double evaluate(Model model) {
		model.setPenVisible(Constants.PEN_SHOWING);
		return 1;
	}

}
