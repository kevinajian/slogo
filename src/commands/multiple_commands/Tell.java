package commands.multiple_commands;

import java.util.ArrayList;
import java.util.List;

import model.Model;
import commands.Command;

public class Tell extends Command{
	protected List<String> myTurtles = new ArrayList<String>();
	
	public List<String> getTurtles() {
		return myTurtles;
	}
	
	public void setTurtles(List<String> turtles) {
		myTurtles = turtles;
	}
	
	@Override
	public double evaluate(Model m) {
		for (String i: myTurtles) {
			if (m.getId() == Integer.parseInt(i)) {
				m.setActive(true);
				return Double.parseDouble(myTurtles.get(myTurtles.size()-1));
			}
			else {
				m.setActive(false);
			}
		}
		return Double.parseDouble(myTurtles.get(myTurtles.size()-1));
	}
}
