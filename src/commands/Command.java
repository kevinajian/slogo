package commands;

import java.util.ArrayList;
import java.util.List;

public abstract class Command {
	protected int myNumParams = 0;
	protected List<Double> myParamList;
	 
	public int getNumInputs(){
		return myNumParams;
	}
	
	public void setParamList(List<Double> paramList){
		myParamList = paramList;
	}
}
