package commands.basic_syntax;

import model.Model;
import commands.Command;

/**
 * Command class for a constant, only has a value
 * @author Kevin
 */
public class Constant extends Command{
	private double myValue;

	public void setValue(double value){
		myValue = value;
	}
	
	@Override
	public double evaluate(Model model) {
		return myValue;
	}
	
}