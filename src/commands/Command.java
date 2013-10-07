package commands;

import java.util.ArrayList;
import java.util.List;

import model.Model;

/**
 * Command class, has number of parameters and a list of those parameters
 * @author Kevin
 */
public abstract class Command {
	protected int myNumInputs = 1;
	protected List<Double> myInputList;
	protected double myInputValueOne;
	protected Command myLeftChild;
	 
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
	
	/**
	 * sets param value and param list
	 */
	public void setInputList(List<Double> inputList){
		setInputValueOne(inputList.get(0));
	}
	
	public void setLeftChild(Command leftChild){
		myLeftChild = leftChild;
	}
}