package commands.multiple_turtles;

import java.util.List;

import model.Model;
import commands.Command;

/**
 * Ask command, evaluates command list for turtles that are given as parameters
 * @author Kevin
 *
 */
public class Ask extends Tell {
	protected List<Command> myCommandList;
	
	public void setCommandList(List<Command> commandList) {
		myCommandList = commandList;
	}
	
	public List<Command> getCommandList() {
		return myCommandList;
	}
	
	/**
	 * Evaluates commands given for only turtles that are specified
	 */
	@Override
	public double evaluate(Model m) {
		double ret = 0;
		System.out.println("active turtles: " +myTurtles);
		for (String s: myTurtles) {
			if (m.getId() == Integer.parseInt(s)) {
				System.out.println("match id: "+m.getId());
				boolean active = m.getActive();
				m.setActive(true);
				for (int i=0; i<myCommandList.size(); i++) {
					System.out.println("evaluating "+myCommandList.get(i).getClass());
					ret = myCommandList.get(i).evaluate(m);					
				}
				m.setActive(active);
			}
		}
		return ret;
	}
}
