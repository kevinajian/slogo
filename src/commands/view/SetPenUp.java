package commands.view;

import parser.Constants;
import model.Model;
import commands.Command;

public class SetPenUp extends Command {

	@Override
	public double evaluate(Model model) {
		model.setPenVisible(Constants.PEN_NOTSHOWING);
		return 0;
	}

}
