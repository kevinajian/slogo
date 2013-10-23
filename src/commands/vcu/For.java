package commands.vcu;

import java.util.List;

import commands.Command;
import commands.CommandList;
import commands.basic_syntax.Variable;
import model.Model;

/**
 * Runs the commands for each value specified in the range, i.e., from start up to end, going by increment.
 * @author Kevin
 *
 */
public class For extends CommandList{
	protected int myIteration;
	protected int myIncrement;
	protected int myMax;
	protected Variable myVariable;
	
	public void setVariable(Variable variable) {
		myVariable = variable;
	}
	
	public Variable getVariable() {
		return myVariable;
	}
	@Override
	public double evaluate(Model model) {
		double ret = 0;
		while(getIteration(model)<getMax()) {
			for (Command c:myCommandList) {
				ret = c.evaluate(model);
			}
			incrementIteration(model);
		}
		return ret;
	}
	
	public void setIteration(int iteration) {
		myIteration = iteration;
	}
	
	public void setMax(int max) {
		myMax = max;
	}
	
	public int getMax() {
		return myMax;
	}
	
	public void setIncrement(int increment) {
		myIncrement = increment;
	}
	
	public int getIncrement() {
		return myIncrement;
	}
	
	public int getIteration(Model model) {
		return (int) model.getVariable(myVariable.getVariableName());
	}
	
	public void incrementIteration(Model model) {
		int currentIteration = getIteration(model);
		int nextIteration = currentIteration + myIncrement;
		model.addVariable(myVariable.getVariableName(), nextIteration);
	}
}
