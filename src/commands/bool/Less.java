package commands.bool;

import model.Model;
import commands.TwoInput;

public class Less extends TwoInput {

	@Override
	public double operation(Model model) {
		if(getInputValueOne() < getInputValueTwo()) {
			return 1;
		}
		return 0;
	}
	
}
