package commands.vcu;

/**
 * Assigns the value of expr to variable, creating the variable if necessary
 * Returns expression
 * @author carlosreyes
 */
public class Make extends ControlStructure {
	
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

}
