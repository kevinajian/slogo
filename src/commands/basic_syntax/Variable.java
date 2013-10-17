package commands.basic_syntax;

import model.Model;
import commands.Command;

public class Variable extends Command{
	String myVariableName;
	
	public Variable(String variableName) {
		myVariableName = variableName;
	}
	
	/**
	 * Gets the variable name that was set.
	 * @return String variable name
	 */
	public String getVariableName() {
		return myVariableName;
	}
	
	/**
	 * Sets the variable name to something different
	 * @param variableName
	 */
	public void setVariableName(String variableName) {
		myVariableName = variableName;
	}
	
}