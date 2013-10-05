package commands.basic_syntax;

import model.Model;
import commands.OneInput;

import parser.Constants;

public class Variable extends OneInput{
	String variableName = null;
	double variableValue = Constants.VARIABLE_DEFAULT;
	
	public String getVariableName() {
		return variableName;
	}
	
	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}
	
	public double getVariableValue() {
		return variableValue;
	}
	public void setVariableValue(double variableValue) {
		this.variableValue = variableValue;
	}
	
	@Override
	public double operation(Model model) {
		return variableValue;
	}	
		
}
