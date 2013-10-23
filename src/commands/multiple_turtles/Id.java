package commands.multiple_turtles;

import model.Model;
import commands.CommandZeroInput;

/**
 * Id command, returns the Id of the selected turtle
 * @author Kevin
 *
 */
public class Id extends CommandZeroInput{

	/**
	 * returns the id of the turtle
	 */
	@Override
	public double evaluate(Model m) {
		return m.getId();
	}
}
