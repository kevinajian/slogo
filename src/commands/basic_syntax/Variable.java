package commands.basic_syntax;

import java.util.List;

import model.Model;
import commands.Command;
import parser.Constants;

public class Variable extends Command{
	String myVariableName = null;
	double myNumInputs = 1;
	
	public String getVariableName() {
		return myVariableName;
	}
	
	public void setVariableName(String variableName) {
		myVariableName = variableName;
	}
	
	@Override
	public double evaluate(Model model) {
		return getInputValueOne();
	}
	
}
