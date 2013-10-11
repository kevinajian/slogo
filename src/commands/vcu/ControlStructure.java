package commands.vcu;

import commands.Command;
import model.Model;

/**
 * Parent class of control structure commands.
 * @author carlosreyes
 *
 */
public class ControlStructure extends Command {
	private String myVariable;
	
	/**
	 * @return myVariable
	 */
	public String getVariable() {
		return myVariable;
	}
	
	/**
	 * Sets myVariable
	 * @param variable
	 */
	public void setVariable(String variable) {
		this.myVariable = variable;
	}
	
	@Override
	public double evaluate(Model model) {
		// TODO Auto-generated method stub
		return 0;
	}

}
