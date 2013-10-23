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
	
	/**
	 * Evaluates commands given for only turtles that are specified
	 */
	@Override
	public double evaluate(Model m) {
		double ret = 0;
		for (String s: myTurtles) {
			if (m.getId() == Integer.parseInt(s)) {
				boolean active = m.getActive();
				m.setActive(true);
				for (Command c: myCommandList) {
					ret = c.evaluate(m);
				}
				m.setActive(active);
			}
		}
		return ret;
	}
}
