package commands.vcu;

/**
 * If expr is not 0, runs the trueCommands given in the first list, 
 * otherwise runs the falseCommands given in the second list
 * Returns the value of the final command executed
 * @author carlosreyes
 */
public class IfElse extends ControlStructure {
	String myName;

	public String getMyName() {
		return myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}
}
