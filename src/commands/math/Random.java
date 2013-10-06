package commands.math;

import commands.OneInput;
import model.Model;

public class Random extends OneInput {

	@Override
	public double operation(Model model) {
		return Math.random()*getInputValue();
	}

}
