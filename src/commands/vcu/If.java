package commands.vcu;

import model.Model;

/**
 * If expr is not 0, runs the commands given in the list.
 * Returns the value of the final command executed.
 * @author carlosreyes
 *
 */
public class If extends Repeat {
	
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
