package commands.basic_syntax;

import java.util.List;

import model.Model;
import commands.OneInput;
import parser.Constants;

public class Variable extends OneInput{
	String myVariableName = null;
	double myVariableValue = Constants.VARIABLE_DEFAULT;
	
	public String getVariableName() {
		return myVariableName;
	}
	
	public void setVariableName(String variableName) {
		myVariableName = variableName;
	}
	
	public double getVariableValue() {
		return myVariableValue;
	}
	
	public void setVariableValue(double variableValue) {
		myVariableValue = variableValue;
	}

	@Override
	public double evaluate() {
		return getInputValueOne();
	}
	
}
