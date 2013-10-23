package commands.basic_syntax;

import commands.Command;

import model.Model;

/**
 * Command for a constant (number)
 * @author Kevin
 *
 */
public class Constant extends Command {
	public double myValue = 0;
	
	/**
	 * sets number of inputs to 0
	 */
	public Constant(){
		super.myNumInputs = 0;
	}
	
	/**
	 * returns the value associated with the constant;
	 */
	@Override
	public double getInputValueOne(Model model) {
		return myValue;
	}
	
	/**
	 * sets the value of the constant;
	 */
	@Override
	public void setInputValueOne(double inputValue) {
		myValue = inputValue;
	}

}
