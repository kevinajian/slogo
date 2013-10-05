package commands.view;

import model.Model;
import commands.Command;

public class HideTurtle implements Command {

	@Override
	public double operation(Model model) {
		model.setMyVisible("invisible");
		return 0;
	}
	
}
