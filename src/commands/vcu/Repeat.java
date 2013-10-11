package commands.vcu;

import model.Model;

/**
 * Runs the commands given in the list the value of expr number of times
 * Returns the value of the final command executed
 * The value of the current iteration, starting at 1, is automatically assigned to the variable
 * :repcount so that it can be accessed by the commands
 * @author carlosreyes
 */
public class Repeat extends ControlStructure {
	private String myExpression;
	public String getMyExpression() {
		return myExpression;
	}
	public void setMyExpression(String myExpression) {
		this.myExpression = myExpression;
	}
	@Override
	public double evaluate(Model model) {
		// TODO Auto-generated method stub
		return 0;
	}

}
