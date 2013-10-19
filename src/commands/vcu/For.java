package commands.vcu;

import commands.Command;
import commands.basic_syntax.Variable;

import model.Model;

/**
 * Runs the commands for each value specified in the range, i.e., from start up to end, going by increment.
 * @author carlosreyes
 *
 */
public class For extends ControlStructure{
	
	private String myVariable;
	private double myMax;
	private double myValue;
	private double myIncrement;
	
	public For() {
		super.myNumInputs = 2;
	}
	
	public double getMyValue() {
		return myValue;
	}

	public void setMyValue(double myValue) {
		this.myValue = myValue;
	}

	public String getMyVariable() {
		return myVariable;
	}

	public void setMyVariable(String myVariable) {
		this.myVariable = myVariable;
	}

	public double getMyMax() {
		return myMax;
	}

	public void setMyMax(double myMax) {
		this.myMax = myMax;
	}

	@Override
	public double evaluate(Model model) {
		//System.out.println(myNumInputs);
		//TODO: Result needs to be the output of every
		//iteration of the loop
		double result = 0.0;
		for(double i=myValue; i<myMax; i+= myIncrement) {
			for (Command command : model.getCommands()) {
				result = command.evaluate(model);
			}
			// setVariableValue(model, myVariable, result);
		}
		return 0;
	}
	
	/**
	 * Set the value of a variable from its name
	 * @return 
	 */
	public void setVariableValue(Model m, String var, double setVal) {
		for(Variable v : m.getVariableList()) {
			if(var.equals(v.getVariableName())) {
				v.setInputValueOne(setVal);
			}
		}
	}
	
}
