package commands.multiple_turtles;

import java.util.ArrayList;
import java.util.List;

import model.Model;
import commands.Command;

/**
 * Tell command, selects turtles to be active. If the turtle is
 * not currently made, this will create a new turtle with that id.
 * @author Kevin
 *
 */
public class Tell extends Command{
	protected List<String> myTurtles = new ArrayList<String>();
	
	public List<String> getTurtles() {
		return myTurtles;
	}
	
	public void setTurtles(List<String> turtles) {
		myTurtles = turtles;
	}
	
	/**
	 * Creates new turtles if the id is not found, and sets the
	 * turtles specified to active.
	 */
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
