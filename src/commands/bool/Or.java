package commands.bool;

import commands.TwoInput;

import model.Model;

public class Or extends TwoInput {
	
	@Override
	public double operation(Model model) {
		if(getInputValueOne() != 0 || getInputValueOne() != 0){
			return 1;
		}
		return 0;
	}
	
}
