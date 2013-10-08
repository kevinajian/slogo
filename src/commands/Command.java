package commands;

import model.Model;

/**
 * Command class, has number of parameters and a list of those parameters
 * @author Kevin, Carlos
 */
public abstract class Command {
	protected int myNumInputs = 2;
	private double myInputValueOne;
	private double myInputValueTwo;
	private Command myLeftChild;
	private Command myRightChild;
	
	 
	/**
	 * gets number of parameters this command holds
	 * @return
	 */
	public int getNumInputs(){
		return myNumInputs;
	}
	
	/**
	 * evaluates operations using parameters
	 * @param model TODO
	 * @param paramList - List<Double> of parameters
	 * @return - double of result
	 */
	public abstract double evaluate(Model model);
	
	/**
	 * gets input value
	 * @return - double of input value
	 */
	public double getInputValueOne() {
		return myLeftChild.getInputValueOne();
	}
	
	/**
	 * sets input value
	 * @param inputValue - value to be set 
	 */
	public void setInputValueOne(double inputValue) {
		myLeftChild.setInputValueOne(inputValue);
	}
	
	public void setLeftChild(Command leftChild){
		myLeftChild = leftChild;
	}
	
	/**
	 * gets second input value
	 * @return - double of first input value
	 */
	public double getInputValueTwo() {
		return myRightChild.getInputValueOne();
	}
	
	/**
	 * sets second input value
	 * @param inputValueTwo - double of value to be set
	 */
	public void setInputValueTwo(double inputValueTwo) {
		myRightChild.setInputValueOne(inputValueTwo);
	}
	
	public void setRightChild(Command rightChild){
		myRightChild = rightChild;
	}
}