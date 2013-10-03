package commands.bool;

import commands.TwoInput;

import model.Model;

public class Greater extends TwoInput{

	@Override
	public double operation(Model model) {
		if(getInputValueOne() > getInputValueTwo()) {
			return 1;
		}
		return 0;
	}
	
}
