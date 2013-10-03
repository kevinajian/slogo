package commands.bool;

import model.Model;
import commands.OneInput;

public class Not extends OneInput {

	@Override
	public double operation(Model model) {
		if (getInputValue() == 0) {
			return 1;
		}
		return 0;
	}

}
