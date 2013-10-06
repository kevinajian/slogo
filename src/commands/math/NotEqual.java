package commands.math;

import commands.TwoInput;

import model.Model;

public class NotEqual extends TwoInput {
	
	@Override
	public double operation(Model model) {
		if(getInputValueOne() != getInputValueTwo()) {
			return 1;
		}
		return 0;
	}
	
}
