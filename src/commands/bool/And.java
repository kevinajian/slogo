package commands.bool;

import model.Model;
import commands.TwoInput;

public class And extends TwoInput {

	@Override
	public double operation(Model model) {
		if(getInputValueOne() != 0 && getInputValueOne() != 0){
			return 1;
		}
		return 0;
	}

}
