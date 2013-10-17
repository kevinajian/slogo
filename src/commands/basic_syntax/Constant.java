package commands.basic_syntax;

import commands.Command;

import model.Model;

public class Constant extends Command {
	public double myValue = 0;
	
	public Constant(){
		super.myNumInputs = 0;
	}
	
	@Override
	public double getInputValueOne() {
		return myValue;
	}
	
	@Override
	public void setInputValueOne(double inputValue) {
		myValue = inputValue;
	}

}
