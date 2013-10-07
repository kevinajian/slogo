package commands.vcu;

import commands.Command;

import model.Model;

public class Constant extends Command {

	public double myValue;
	
	public double getMyValue() {
		return myValue;
	}

	public void setMyValue(double myValue) {
		this.myValue = myValue;
	}

	@Override
	public double evaluate(Model model) {
		return 0;
	}

}
