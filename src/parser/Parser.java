package parser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import commands.Command;
import commands.OneInput;
import commands.TwoInput;
import commands.turtle_commands.direction.Forward;

/**
 * Parses user input
 * @author Kevin, Carlos
 *
 */
public class Parser {
	private Tree<Command> myTree;
	
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
	 * creates classes from list of user input
	 * @param list - String[] of user input
	 * @throws ClassNotFoundException 
	 */
	private Command lexer(List<String> inputs){
		for (int i=0; i<inputs.size(); i++){
			if (inputs.get(i).getClass() instanceof OneInput){
				
			
			}
			if {input 
				
				
			}
			else if
			else lexer(inputs);
		}
	}
	
	
//	private void lexer(String[] input){
//		//iterator
//		for (String s : input){
//			Command current = s.toCommand();
//			
//			if (s.value.getClass() instanceof OneInput){
//				current.leftChild = s.next.toCommand();
//				current.leftChild.parent = current;
//			}
//			
//			if (myTree.current.value.getClass() instanceof TwoInput){
//				current.leftChild.
//			}
//
//			else if (myTree.root.value.getClass() instanceof Command) {
//				
//			}
//			
//			
//			
//			System.out.println(string);
//		}
//	}
	
	private static final String PATH = "commands.*";
	
	public void toClass(String in) {
		String command = PATH + in;
	}
	
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		String className = "commands.turtle_commands.direction.Forward";
		Object xyz = Class.forName(className).newInstance();
		System.out.println(xyz.getClass()); 
	}
}
