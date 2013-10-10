package commands.vcu;

import commands.Command;
import model.Model;

public class ControlStructure extends Command {
	private String myVariable;
	
	public String getVariable() {
		return myVariable;
	}
	public void setVariable(String variable) {
		this.myVariable = variable;
	}
	
	@Override
	public double evaluate(Model model) {
		// TODO Auto-generated method stub
		return 0;
	}

}
