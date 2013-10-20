package commands.vcu;

import commands.Command;
import commands.basic_syntax.Constant;

import model.Model;

/**
 * Runs the commands given in the list the value of expr number of times
 * Returns the value of the final command executed
 * The value of the current iteration, starting at 1, is automatically assigned to the variable
 * :repcount so that it can be accessed by the commands
 * @author carlosreyes
 */
public class Repeat extends Command {

	@Override
	public double evaluate(Model model) {
		Constant c = (Constant) myLeftChild;
		double x = 0;
		for (int i = 0; i<c.myValue; i++) {
			x += myRightChild.evaluate(model);
		}
		return x;
	}

	public void setMyExpression(String string) {
		// TODO Auto-generated method stub
		
	}

}
