package commands.vcu;

import java.util.List;
import model.Model;
import commands.Command;

public class For extends Command{
	private double myVariable;
	public double getMyVariable() {
		return myVariable;
	}

	public void setMyVariable(double myVariable) {
		this.myVariable = myVariable;
	}

	public double getMyMax() {
		return myMax;
	}

	public void setMyMax(double myMax) {
		this.myMax = myMax;
	}

	private double myMax;
	
	
	public double evaluate(Model model, List<String> commandList) {
		
		
		return 0;
		
	}

	@Override
	public double evaluate(Model model) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
