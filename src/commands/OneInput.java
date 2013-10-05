package commands;

import model.Model;

public abstract class OneInput extends Command{

	/**
	 * Carries out an operation.
	 * @param model
	 * @return
	 */
	private double inputValue;
		
	public double getInputValue() {
		return inputValue;
	}
	
	public void setInputValue(double inputValue) {
		this.inputValue = inputValue;
	}
	
	public abstract double operation (Model model);


}
