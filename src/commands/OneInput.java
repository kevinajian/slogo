package commands;

public abstract class OneInput extends Command{

	private int numParaams = 1;

	/**
	 * Carries out an operation.
	 * @param model
	 * @return
	 */
	private double inputValue;
	private int numParams = 1;
	public double getInputValue() {
		return inputValue;
	}
	
	public void setInputValue(double inputValue) {
		this.inputValue = inputValue;
	}
}
