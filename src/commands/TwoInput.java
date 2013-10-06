package commands;

import java.util.List;

public abstract class TwoInput extends Command{
	private int myNumParams = 2;
	private double inputValueOne;
	private double inputValueTwo;
		
	public double getInputValueOne() {
		return inputValueOne;
	}
	
	public void setInputValueOne(double inputValueOne) {
		this.inputValueOne = inputValueOne;
	}
	
	public double getInputValueTwo() {
		return inputValueTwo;
	}
	
	public void setInputValueTwo(double inputValueTwo) {
		this.inputValueTwo = inputValueTwo;
	}
	
	public abstract double evaluate(List<Double> paramList);

}
