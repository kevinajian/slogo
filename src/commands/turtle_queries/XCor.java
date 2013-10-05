package commands.turtle_queries;

import model.Model;
import commands.Command;

public class XCor implements Command {

	@Override
	public double operation(Model model) {
		return model.getX();
	}

}
