package commands;

import java.util.List;

public abstract class OneInput extends Command{
	private int myNumParams = 1;
	
	private double inputValue;
	
	
	public double getInputValue() {
		return inputValue;
	}
	
	public void setInputValue(double inputValue) {
		this.inputValue = inputValue;
	}
	
	public abstract double evaluate(List<Double> paramList);
}
