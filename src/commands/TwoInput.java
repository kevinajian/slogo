package commands;

import java.util.List;

/**
 * Command class for two input parameters
 * @author Kevin
 *
 */
public abstract class TwoInput extends Command{
	private int myNumInputs = 2;
	private double myInputValueTwo;
	public Command myRightChild;
	
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
	
	/**
	 * sets input value and input list
	 */
	public void setInputList(List<Double> inputList){
		super.setInputList(inputList);
		setInputValueTwo(inputList.get(1));
	}
	
	public void setRightChild(Command rightChild){
		myRightChild = rightChild;
	}
}
