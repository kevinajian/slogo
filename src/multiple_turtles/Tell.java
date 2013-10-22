package multiple_turtles;

import java.util.ArrayList;
import java.util.List;

import model.Model;
import commands.Command;

public class Tell extends Command{
	List<Integer> myTurtles = new ArrayList<Integer>();
	
	@Override
	public double evaluate(Model m) {
		for (int i: myTurtles) {
			if (m.getId() == i) {
				m.setActive(true);
				return myTurtles.get(myTurtles.size()-1);
			}
			else {
				m.setActive(false);
			}
		}
		return myTurtles.get(myTurtles.size()-1);
	}
	
}
