package parser;

import java.util.ArrayList;
import java.util.List;
import model.Model;
import commands.Command;
import commands.NInputs;
import commands.basic_syntax.Constant;


/**
 * Takes in input String and tokenizes this. Uses these
 * tokens in a recursive parse tree to build and execute the
 * commands as they are converted into their classes when
 * building the tree.
 * @author carlosreyes, Kevin
 *
 */
public class Parser {
	private List<String> inputs;
	private Model myModel;
	
	public Parser(Model model){
		myModel = model;
	}
	
	/**
	 * Splits user input and passes results to lexer
	 * @param input - String of user input
	 * @throws Exception 
	 */
	public void parse(String input) throws Exception{
		input.toUpperCase();
		String [] list = input.split("\\s+");
		
//		this will be in lexer / treeBuilder. just check for : and make a variable there.
//		for(int i=0; i <list.length; i++){
//		//for (String item:list){
//			//Handles variables
//			if(list[i].substring(0, 1).equals(":") && !myModel.getVariableMap().containsKey(list[i].substring(0))) {
//				myModel.getVariableMap().put(list[i].substring(0), Double.parseDouble(list[i+1]));
//				inputs.add("Variable");
//				inputs.add(list[i].substring(0));
//				i++;
//			}
//			else if(list[i].substring(0, 1).equals(":")) {
//				inputs.add("Variable");
//				inputs.add(myModel.getVariableMap().get(list[i].substring(0)).toString());
//			}
//			else {
//				inputs.add(list[i]);
//			}
//		}
		
		lexer(inputs);
	}
	
	/**
	 * Makes a list of trees by storing their root, loops over
	 * all commands tokenized by the parse method, and calls
	 * treebuilder, putting the root in an array of roots.
	 * @param inputs
	 * @throws Exception
	 */
	private void lexer(List<String> inputs) throws Exception{
		List<Command> rootList = new ArrayList<Command>();
		
		while(inputs.size() > 1) {
			Command headNode = getClass(inputs.get(0));
			treeBuilder(headNode);
			inputs.remove(0);
			rootList.add(headNode);
		}
	}
	
	/**
	 * Recursively builds a tree of commands from a list of
	 * Strings. Creates instances of the appropriate classes
	 * when it encounters strings of the same name and executes
	 * the function of the classes.
	 * @param root
	 * @return Command which is the root Node of the tree
	 * @throws Exception
	 */
	private Command treeBuilder(Command root) throws Exception{
		
//		if (root.getMyCommand() instanceof ControlStructure){
//			Queue queue = new Queue();
//		}
		
		if (root.getNumInputs() == 0) {
			return root;
		}

		//was instance of TwoInputs
		if (root.getNumInputs() == 2) {
			Command curr = getClass(inputs.get(1));
			inputs.remove(0);
			root.setLeftChild(treeBuilder(curr));
			
			curr = getClass(inputs.get(1));
			inputs.remove(0);
			root.setRightChild(treeBuilder(curr));
		}

		//was instance of OneInput
		if (root.getNumInputs() == 1) {
			Command curr = getClass(inputs.get(1));
			inputs.remove(0);
			root.setLeftChild(treeBuilder(curr));
		}
		
		if (root instanceof Constant) {
			root.setInputValueOne(Double.parseDouble(inputs.get(0)));
			return root;
		}	
		//Should this be here?
		return root;
		
	}
	
	/**
	 * Creates a class from a string.
	 * @param className
	 * @return A class that is a subclass of Command, based off of the string given.
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	private Command getClass(String className) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Command xyz = (Command) Class.forName(toClass(className)).newInstance();
		return xyz;
	}
	
	/**
	 * Gets file path from String that represents a class.
	 * @param in
	 * @return String that is the package path to that class.
	 */
	public String toClass(String in) {
		FindFilePath filePath = new FindFilePath(in);
		return filePath.makePath();
	}
	
	
}
