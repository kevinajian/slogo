package commands;

import java.util.List;

/**
 * Command class for one input parameter
 * @author Kevin
 */
public abstract class OneInput extends Command{
	protected int myNumInputs = 1;
	protected double myInputValueOne;
	
	/**
	 * gets input value
	 * @return - double of input value
	 */
	public double getInputValueOne() {
		return myInputValueOne;
	}
	
	/**
	 * sets input value
	 * @param inputValue - value to be set 
	 */
	public void setInputValueOne(double inputValue) {
		myInputValueOne = inputValue;
	}
	
	/**
	 * sets param value and param list
	 */
	public void setInputList(List<Double> inputList){
		super.setInputList(inputList);
		setInputValueOne(inputList.get(0));
	}
}