package commands.basic_syntax;

import model.Model;
import commands.Command;
import commands.CommandOneInput;
import commands.CommandZeroInput;

public class Variable extends CommandZeroInput{
	String myVariableName;
	double variableValue;
	
	public double getVariableValue() {
		return variableValue;
	}

	public void setVariableValue(double variableValue) {
		this.variableValue = variableValue;
	}

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
	
	@Override
	public double evaluate(Model model) {
		//variableValue = myLeftChild.getInputValueOne(model);
		//System.out.println(model.getCustomCommandMap().get(myVariableName));
		return model.getCustomCommandMap().get(myVariableName);
	}
	
}