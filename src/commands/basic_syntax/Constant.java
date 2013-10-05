package commands.basic_syntax;

import model.Model;
import commands.Command;

public class Constant extends Command{
	private double value;
	@Override
	public double operation(Model model) {
		return value;
	}
	
}
