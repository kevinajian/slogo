package commands;

import java.util.ArrayList;
import java.util.List;

import model.Model;

/**
 * Command class, has number of parameters and a list of those parameters
 * @author Kevin
 */
public abstract class Command {
	protected int myNumInputs = 0;
	protected List<Double> myInputList;
	 
	/**
	 * gets number of parameters this command holds
	 * @return
	 */
	public int getNumInputs(){
		return myNumInputs;
	}
	
	/**
	 * sets list of parameters
	 * @param paramList - List<Double> of parameters
	 */
	public void setInputList(List<Double> inputList){
		myInputList = inputList;
	}
	
	/**
	 * evaluates operations using parameters
	 * @param model TODO
	 * @param paramList - List<Double> of parameters
	 * @return - double of result
	 */
	public abstract double evaluate(Model model);
}