package commands.multiple_turtles;

import model.Model;
import commands.Command;

/**
 * AskWith command, evaluates commands given for turtles that satisfy the provided expression
 * @author Kevin
 *
 */
public class AskWith extends Ask {
	private Command myExpression;
	
	public void setExpression(Command c) {
		myExpression = c;
	}
	
	public Command getExpression() {
		return myExpression;
	}
	
	/**
	 * If the turtle satisfies the expression, the command list will be run for that turtle
	 */
	@Override
	public double evaluate(Model m) {
		double ret = 0;
		double result = myExpression.evaluate(m);
		if (result == 1) {
			boolean active = m.getActive();
			m.setActive(true);
			for (Command c: myCommandList) {
				ret = c.evaluate(m);
			}
			m.setActive(active);
		}
		return ret;
	}
}
