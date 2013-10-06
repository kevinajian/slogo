package commands.turtle_queries;

import model.Model;
import commands.Command;

public class XCor extends Command {

	@Override
	public double evaluate(Model model) {
		return model.getX();
	}

}
