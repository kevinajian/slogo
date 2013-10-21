package commands.vcu;

import java.util.List;

import model.Model;
import commands.Command;

public class Loop extends Command{
	private int myIteration;
	private int myMax;
	private List<Command> myCommandList;
	
	@Override
	public double evaluate(Model model) {
		while(getIteration()<getMax()) {
			for (Command c:myCommandList) {
				c.evaluate(model);
			}
		}
		return 0;
	}
	
	private int getIteration() {
		return myIteration;
	}
	
	private int getMax() {
		return myMax;
	}
	
	public void setCommandList(List<Command> commandList) {
		myCommandList = commandList;
	}
	
}
