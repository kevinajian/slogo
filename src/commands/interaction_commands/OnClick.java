package commands.interaction_commands;

import parser.Parser;
import model.Constants;
import model.Model;
import commands.Command;
import commands.basic_syntax.Variable;

/**
 * If defined by the user in the customCommandMap,
 * this function will execute the command set to it with
 * the mouse's x and y coordinates as arguements.
 * @author carlosreyes
 *
 */
public class OnClick extends Command {
	
	@Override
	public double evaluate(Model model) {
		Parser parser = new Parser();
		Command customCommand = null;
		try {
			//customCommand = parser.getClass("SetXY");
			String[] command = model.getCustomCommandMap().get("OnClick").split(Constants.INPUT_SPLITTER);
			customCommand = parser.getClass(command[0]);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		setVariables(customCommand, model);
		customCommand.evaluate(model);
		return myNumInputs;	
	}
	
	/**
	 * sets the variables x and y to the left and right child of this command.
	 * @param customCommand
	 * @param model
	 */
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
