package commands.interaction_commands;

import parser.Parser;
import model.Constants;
import model.Model;
import commands.Command;
import commands.CommandZeroInput;
import commands.basic_syntax.Variable;

import jgame.platform.*;

public class OnKey extends CommandZeroInput {
	
	@Override
	public double evaluate(Model model) {
		Parser parser = new Parser();
		Command customCommand = null;

		String[] command = model.getCustomCommandMap().get("OnKey").split(Constants.INPUT_SPLITTER);
		customCommand = parser.getClass(command[0]);

		setVariables(customCommand, model);
		customCommand.evaluate(model);
		return myNumInputs;	
	}
	
	public void setVariables(Command customCommand, Model model) {
		Variable x = new Variable("X");
		x.setVariableValue(getInputValueOne(model));
		model.addVariable(x.getVariableName(), x.getVariableValue());
		
		Variable y = new Variable("Y");
		y.setVariableValue(getInputValueTwo(model));
		model.addVariable(y.getVariableName(), y.getVariableValue());
		
		customCommand.setLeftChild(x);
		customCommand.setRightChild(y);
	}
}
