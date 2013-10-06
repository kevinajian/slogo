package commands.math;

import java.util.List;

import commands.OneInput;
import model.Model;

public class ATan extends OneInput {

	@Override
	public double evaluate(List<Double> paramList) {
		return Math.atan(getInputValue());
	}

}
