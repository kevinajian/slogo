package commands.view;

import model.Model;
import commands.Command;

public class PenUp implements Command {

	@Override
	public double operation(Model model) {
		model.setMyPenPos("up");
		return 0;
	}

}
