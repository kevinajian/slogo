package commands.view;

import model.Model;
import commands.Command;

public class ShowTurtle extends Command {

	@Override
	public double operation(Model model) {
		model.setMyVisible("visible");
		return 0;
	}
	
}
