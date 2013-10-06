package parser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import commands.Command;
import commands.OneInput;
import commands.TwoInput;
import commands.turtle_commands.direction.Forward;
import commands.basic_syntax.Constant;

/**
 * Parses user input
 * @author Kevin, Carlos
 *
 */
public class Parser {
	private List<Command> commandList = new ArrayList<Command>();
	
	public Parser(){
	}
	
	/**
	 * splits user input and passes results to lexer
	 * @param input - String of user input
	 */
	public void parse(String input){
		input.toUpperCase();
		String [] list = input.split("\\s+");
		List<String> inputs = new ArrayList<String>();
		for (String item:list){
			inputs.add(item);
		}
		lexer(inputs);
	}
	
	/**
	 * creates Command objects from user input
	 * @param inputs - List<String> of user input 
	 */
	private void lexer(List<String> inputs){
		
		for(int j = inputs.size()-1; j>=0; j--) { //traverses the array of string inputs BACKWARDS
			List<Double> constantList  = new ArrayList<Double>();

			if(getClass(inputs.get(j)) instanceof Constant) { //If the one we're on is a constant,
				continue; //move on!!!!!!!!!!!!!!!!
			}
			else { //otherwise, if its not a constant
				double n = getClass(inputs.get(j)).getNumInputs(); //then set n = # of params that command needs 
				for(double m=1; m<=n; m++) { //go forward in the list n spots
					constantList.add(j+m); //add the constants to a list of commands that will be fed to our command
					inputs.remove(j+1);
				}
				Command current = getClass(inputs.get(j));
				current.setConstantList(constantList);
				Double newVal = current.evaluate(constantList); //feed all params in list to the command, and execute, set to newVal
				if affects turtle commandList(current);
				inputs.set(j, newVal.toString()); //we will put newVal in the place where the other shit was
			}
		}
	}
	
	private Command getClass(String className){
		Command xyz = (Command) Class.forName(toClass(className)).newInstance();
		return xyz;
	}

	private static final String PATH = "commands.*";
	
	public String toClass(String in) {
		return PATH + in;
	}
	
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		String className = "commands.turtle_commands.direction.Forward";
		Object xyz = Class.forName(className).newInstance();
		System.out.println(xyz.getClass()); 
	}
}
