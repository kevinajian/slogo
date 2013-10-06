package commands;

import java.util.ArrayList;
import java.util.List;

import model.Model;

/**
 * Command that takes in n parameters
 * Has a String for command name
 * @author Kevin
 *
 */
public class NInputs extends Command{
	private String myCommandName;
	
	/**
	 * constructor, sets number of parameters
	 * @param i
	 */
	public NInputs(String commandName, int i){
		myCommandName = commandName;
		myNumInputs = i;
	}

	@Override
	public double evaluate(Model model) {
		// TODO Auto-generated method stub
		return 0;
	}
}