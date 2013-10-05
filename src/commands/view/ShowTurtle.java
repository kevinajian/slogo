package commands.view;

import model.Model;
import commands.Command;

public class ShowTurtle implements Command {

	@Override
	public double operation(Model model) {
		model.setMyVisible("visible");
		return 0;
	}
	
}
