package commands.view;

import model.Model;
import commands.Command;

public class PenDown extends Command {

	@Override
	public double evaluate(Model model) {
		model.setMyPenPos("down");
		return 1;
	}

}
