package commands.vcu;

import java.util.List;

import commands.Command;
import commands.basic_syntax.Variable;
import model.Model;

/**
 * Runs the commands for each value specified in the range, i.e., from start up to end, going by increment.
 * @author Kevin, clos.
 *
 */
public class For extends Loop{
	protected int myIteration;
	protected int myIncrement;
	protected int myMax;
	protected List<Command> myCommandList;
	protected Variable myVariable;
	
	public void setVariable(Variable variable) {
		myVariable = variable;
	}
	
	public Variable getVariable() {
		return myVariable;
	}
	@Override
	public double evaluate(Model model) {
		while(getIteration(model)<getMax()) {
			for (Command c:myCommandList) {
				c.evaluate(model);
			}
			incrementIteration(model);
		}
		return 0;
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
	
	public void setCommandList(List<Command> commandList) {
		myCommandList = commandList;
	}

	public List<Command> getCommandList() {
		return myCommandList;
	}
	
	public void setIncrement(int increment) {
		myIncrement = increment;
	}
	
	public int getIncrement() {
		return myIncrement;
	}
	
	public int getIteration(Model model) {
		return (int) model.getCustomCommandValue(myVariable.getVariableName());
	}
	
	public void incrementIteration(Model model) {
		int currentIteration = getIteration(model);
		int nextIteration = currentIteration + myIncrement;
		model.setCustomCommand(myVariable.getVariableName(), nextIteration);
	}
	
	
	
}
