package commands.math;

import java.util.List;

import model.Model;
import commands.TwoInput;

public class And extends TwoInput {

	@Override
	public double evaluate(List<Double> paramList) {
		if ((paramList.get(0) != 0) && (paramList.get(1) != 0)) return 1;
		return 0;
	}


}
