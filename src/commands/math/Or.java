package commands.math;

import model.Model;
import commands.Command;

/**
 * returns 1 if either input value is not 0
 * else returns 0
 * @author Kevin
 *
 */
public class Or extends Command {
	
	@Override
	public double evaluate(Model model) {
		if(getInputValueOne() != 0 || getInputValueTwo() != 0){
			return 1;
		}
		return 0;
	}
	
}
