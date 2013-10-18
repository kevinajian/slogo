package commands.vcu;

import parser.Parser;
import model.Model;
import commands.Command;
import commands.CommandZeroInput;

/**
 * Assigns the value of expr to variable, creating the variable if necessary
 * Returns expression
 * @author carlosreyes
 */
public class Make extends Command {
	
	private String variable;
	private String expression;
	
	public String getVariable() {
		return variable;
	}
	public void setVariable(String variable) {
		this.variable = variable;
	}
	public String getExpression() {
		return expression;
	}
	public void setExpression(String expression) {
		this.expression = expression;
	}
	
	@Override
	public double evaluate(Model model) {
		String key = model.getStringCommands().get(1).toString();
		System.out.println(key);
		String commandString = "";
		
		for (String string : model.getStringCommands().subList(2, 
				model.getStringCommands().size()))
		{
			commandString += string;
			commandString += " ";
		}
		System.out.println(commandString);
		model.getCustomCommandMap().put(key, commandString);
		return 0;
	}
	
	
}
