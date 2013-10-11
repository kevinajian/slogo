package commands.vcu;

import model.Model;

/**
 * Runs the commands for each value specified in the range, i.e., from 0 up to (limit - 1).
 * @author carlosreyes
 *
 */
public class DoTimes extends For {
	
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

	@Override
	public double evaluate(Model model) {
		return 0;
	}

}
