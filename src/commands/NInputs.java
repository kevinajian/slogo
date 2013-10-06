package commands;

import java.util.ArrayList;
import java.util.List;

import model.Model;

public class NInputs extends Command{
	private String commandName;
	
	public NInputs(int i){
		myNumParams = i;
	}
	
	public int getNumParams(){
		return myNumParams;
	}
}