package multiple_turtles;

import java.util.List;

import model.Model;
import commands.Command;

public class Ask extends Tell {
	protected List<Command> myCommandList;
	
	public void setCommandList(List<Command> commandList) {
		myCommandList = commandList;
	}
	
	public List<Command> getCommandList() {
		return myCommandList;
	}
	
	@Override
	public double evaluate(Model m) {
		double ret = 0;
		for (String s: myTurtles) {
			if (m.getId() == Integer.parseInt(s)) {
				boolean active = m.getActive();
				m.setActive(true);
				for (int i=0; i<myCommandList.size()-1; i++) {
						ret = myCommandList.get(i).evaluate(m);					
				}
				m.setActive(active);
			}
		}
		return ret;
	}
}
