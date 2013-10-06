package commands;

import java.util.ArrayList;
import java.util.List;

import model.Model;

public class NInputs{
	private List<Command> inputs = new ArrayList<Command>();
	private int numInputs;
	private String commandName;
	
	public NInputs(int i){
		numInputs = i;
	}
	
	public int getNumInputs(){
		return numInputs;
	}
}