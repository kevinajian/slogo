package commands.basic_syntax;

import model.Model;
import parser.Constants;

public class Variable {
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
		
}
