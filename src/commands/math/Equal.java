package commands.math;

import java.util.List;

import model.Model;
import commands.TwoInput;

/**
 * checks if two values are equal
 * @author Kevin
 *
 */
public class Equal extends TwoInput{
	@Override
	public double evaluate(){
		if (getInputValueOne() == getInputValueTwo()) {
			return 1;
		}
		return 0;
	}
}
