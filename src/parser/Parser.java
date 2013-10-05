package parser;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import commands.Command;
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
		
		lexer(list);
	}
	
	/**
	 * creates classes from list of user input
	 * @param list - String[] of user input
	 * @throws ClassNotFoundException 
	 */
	private void lexer(String[] input){
		//iterator
		for (int i=0; i< input.length; i++){
			
			myTree.current.value = string.toClass();
			
			if (myTree.current.value.getClass() instanceof TwoInput){
				
			}
			if (myTree.current.value.getClass() instanceof OneInput){
				myTree.leftChild = null;
				current = myTree.rightChild;
			}
			else if (myTree.root.value.getClass() instanceof NInput) {
				
			}
			
			
			
			System.out.println(string);
		}
	}
	
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		String className = "commands.turtle_commands.direction.Forward";
		Object xyz = Class.forName(className).newInstance();
		System.out.println(xyz.getClass());
	}
}
