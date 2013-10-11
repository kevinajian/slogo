package commands.vcu;

/**
 * Assigns commands given in the second list to commandName using parameters given in first list as variables
 * When commandName is used later in a program, any given values are assigned to variables that can be accessed when the command list is run
 * Returns 1 if command is successfully defined, otherwise 0
 * @author carlosreyes
 *
 */
public class To extends IfElse {
	String myName;

	public String getMyName() {
		return myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}
}
