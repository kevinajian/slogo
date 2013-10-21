package commands.vcu;

import model.Model;
import commands.Command;
import commands.basic_syntax.Variable;

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
		Variable var = (Variable) myLeftChild;

		String key = var.getVariableName();
		double value = myRightChild.evaluate(model);
		
		model.setCustomCommand(key, value);
		System.out.println(model.getCustomCommandMap().keySet());
		System.out.println(model.getCustomCommandMap().values());

		return 0;
	}
	
	
}
