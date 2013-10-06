package commands.math;

import commands.OneInput;

import model.Model;

public class Log extends OneInput{

	@Override
	public double operation(Model model) {
		return Math.log(getInputValue());
	}

}
