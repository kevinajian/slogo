package commands.vcu;

import java.util.List;

import model.Model;
import commands.Command;

/**
 * If expr is not 0, runs the trueCommands given in the first list, 
 * otherwise runs the falseCommands given in the second list
 * Returns the value of the final command executed
 * @author carlosreyes, kevin
 */
public class IfElse extends If {
	protected List<Command> myCommandList2;
	
	public void setCommandList2(List<Command> commandList) {
		myCommandList2 = commandList;
	}

	public List<Command> getCommandList2() {
		return myCommandList2;
	}
	
	@Override
	public double evaluate(Model model) {
		double ret = 0;
		if (myExpression.evaluate(model) != 0) {
			for (Command c: myCommandList) {
				ret = c.evaluate(model);
			}
		}
		else {
			for (Command c: myCommandList2) {
				ret = c.evaluate(model);
			}
		}
		return ret;
	}
	
}
