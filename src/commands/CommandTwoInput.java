package commands;

public abstract class CommandTwoInput extends Command{
	protected Command myRightChild;
	
	public CommandTwoInput() {
		super.myNumInputs = 2;
	}
	
	/**
	 * Gets second input value
	 * @return - double of first input value
	 */
	public double getInputValueTwo() {
		return myRightChild.getInputValueOne();
	}
	
	/**
	 * Sets second input value
	 * @param inputValueTwo - double of value to be set
	 */
	public void setInputValueTwo(double inputValueTwo) {
		myRightChild.setInputValueOne(inputValueTwo);
	}
	
	/**
	 * Sets the right child of this command
	 * @param rightChild (Command)
	 */
	public void setRightChild(Command rightChild){
		myRightChild = rightChild;
	}
}