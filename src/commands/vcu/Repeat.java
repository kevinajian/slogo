package commands.vcu;

import model.Model;
import commands.Command;

public class Repeat extends ControlStructure {
	private String myExpression;
	public String getMyExpression() {
		return myExpression;
	}
	public void setMyExpression(String myExpression) {
		this.myExpression = myExpression;
	}
	@Override
	public double evaluate(Model model) {
		// TODO Auto-generated method stub
		return 0;
	}

}
