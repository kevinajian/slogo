package commands;

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

}
