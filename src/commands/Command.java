package commands;

import model.Model;

/**
* Command class, has number of parameters and a list of those parameters
* also holds the left and right children commands for use with the recursive
* syntax tree.
* @author Kevin, Carlos
*/
public abstract class Command {
	protected int myNumInputs = 2;
	protected Command myLeftChild;
	protected Command myRightChild;
	
	/**
	 * Gets number of parameters this command holds
	 * @return number of inputs
	 */
	public int getNumInputs(){
		return myNumInputs;
	}
	
	/**
	 * Gets input value
	 * @return - double of input value
	 */
	public double getInputValueOne(Model model) {
		return myLeftChild.evaluate(model);
	}
	
	/**
	 * Sets input value
	 * @param inputValue - value to be set 
	 */
	public void setInputValueOne(double inputValue) {
		myLeftChild.setInputValueOne(inputValue);
	}
	
	/**
	 * Sets left child (type command) of this command
	 * @param leftChild (Command)
	 */
	public void setLeftChild(Command leftChild){
		myLeftChild = leftChild;
	}
	
	/**
	 * Evaluates operations using parameters
	 * @param model
	 * @param paramList - List<Double> of parameters
	 * @return - double of result
	 */
	public double evaluate(Model model) {
		return getInputValueOne(model);
	}

	/**
	 * Gets second input value
	 * @return - double of first input value
	 */
	public double getInputValueTwo(Model model) {
		return myRightChild.evaluate(model);
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


