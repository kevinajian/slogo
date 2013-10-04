package commands.turtle_queries;

import model.Model;
import commands.Command;

public class Showing implements Command {

	@Override
	public double operation(Model model) {
		return model.isShowing();
	}

}
