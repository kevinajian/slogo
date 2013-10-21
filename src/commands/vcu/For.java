package commands.vcu;

import java.util.List;

import commands.Command;
import commands.basic_syntax.Variable;
import model.Model;

/**
 * Runs the commands for each value specified in the range, i.e., from start up to end, going by increment.
 * @author carlosreyes
 *
 */
public class For extends Loop{
	private Variable myVariable;
	
	public void setVariable(Variable variable) {
		myVariable = variable;
	}
	
	public Variable getVariable() {
		return myVariable;
	}
	
	@Override
	public int getIteration(Model model) {
		return (int) model.getCustomCommandValue(myVariable.getVariableName());
	}
	
	@Override
	public void incrementIteration(Model model) {
		int currentIteration = getIteration(model);
		int nextIteration = currentIteration + myIncrement;
		model.setCustomCommand(myVariable.getVariableName(), nextIteration);
	}
	
}
