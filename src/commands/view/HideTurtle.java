package commands.view;

import model.Model;
import commands.Command;

public class HideTurtle extends Command {

	@Override
	public double operation(Model model) {
		model.setMyVisible("invisible");
		return 0;
	}
	
}
