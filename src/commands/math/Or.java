package commands.math;

import commands.TwoInput;

import model.Model;

/**
 * returns 1 if either input value is not 0
 * else returns 0
 * @author Kevin
 *
 */
public class Or extends TwoInput {
	
	@Override
	public double evaluate() {
		if(getInputValueOne() != 0 || getInputValueOne() != 0){
			return 1;
		}
		return 0;
	}
	
}
