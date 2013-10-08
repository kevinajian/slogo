package commands.vcu;

import java.util.List;
import model.Model;
import commands.Command;

public class For extends ControlStructure{
	private String myVariable;
	private double myMax;
	private double myValue;
	public double getMyValue() {
		return myValue;
	}

	public void setMyValue(double myValue) {
		this.myValue = myValue;
	}

	public String getMyVariable() {
		return myVariable;
	}

	public void setMyVariable(String myVariable) {
		this.myVariable = myVariable;
	}

	public double getMyMax() {
		return myMax;
	}

	public void setMyMax(double myMax) {
		this.myMax = myMax;
	}


	
	
	public double evaluate(Model model, List<String> commandList) {
		
		
		return 0;
		
	}

	@Override
	public double evaluate(Model model) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
