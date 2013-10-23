package commands.vcu;

import commands.Command;
import commands.CommandList;
import model.Model;

/**
 * If expr is not 0, runs the commands given in the list.
 * Returns the value of the final command executed.
 * @author kevin
 *
 */
public class If extends CommandList {
	protected Command myExpression;
	
	public Command getExpression() {
		return myExpression;
	}
	
	public void setExpression(Command expression) {
		myExpression = expression;
	}
	
	@Override
	public double evaluate(Model model) {
		double ret = 0;
		if (myExpression.evaluate(model) != 0) {
			for (Command c: myCommandList) {
				ret = c.evaluate(model);
			}
		}
		return ret;
	}
}