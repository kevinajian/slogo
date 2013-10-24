package commands.basic_syntax;

import model.Model;
import commands.Command;
import commands.CommandOneInput;
import commands.CommandZeroInput;

/**
 * Variable class
 * @author Kevin
 *
 */
public class Variable extends CommandZeroInput{
	String myVariableName;
	double variableValue;
	
	/**
	 * returns variable's value
	 * @return - double of value
	 */
	public double getVariableValue() {
		return variableValue;
	}

	/**
	 * sets variable's value
	 * @param variableValue - value to be set
	 */
	public void setVariableValue(double variableValue) {
		this.variableValue = variableValue;
	}

	/**
	 * creates a variable and sets the name
	 * @param variableName - name of variable to be set
	 */
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
	
	/**
	 * returns the variable's value
	 */
	@Override
	public double evaluate(Model model) {
		return model.getVariable(myVariableName);
	}
	
}