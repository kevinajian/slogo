package commands.basic_syntax;

import model.Model;
import commands.Command;

public class Variable extends Command{
	String myVariableName = null;
	double myNumInputs = 1;
	
	public Variable(String variableName) {
		this.myVariableName = variableName;
	}
	
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
