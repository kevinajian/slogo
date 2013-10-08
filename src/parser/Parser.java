package parser;

import java.util.ArrayList;
import java.util.List;
import model.Model;
import commands.Command;
import commands.basic_syntax.Constant;
import commands.basic_syntax.Variable;
import commands.vcu.ControlStructure;
import commands.vcu.For;
import commands.vcu.*;


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
		
		for(String string:list){
			inputs.add(string);
		}
		
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
		List<String> inputList = new ArrayList<String>();
		while(inputs.size() > 1) {
			Command headNode = getClass(inputs.get(0));
			if(headNode instanceof ControlStructure) {
				controlTree(headNode, inputList);
			}
			treeBuilder(headNode, inputs);
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
	private Command treeBuilder(Command root, List<String> inputs) throws Exception{
		
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
			root.setLeftChild(treeBuilder(curr, inputs));
			
			curr = getClass(inputs.get(1));
			inputs.remove(0);
			root.setRightChild(treeBuilder(curr, inputs));
		}

		//was instance of OneInput
		if (root.getNumInputs() == 1) {
			Command curr = getClass(inputs.get(1));
			inputs.remove(0);
			root.setLeftChild(treeBuilder(curr, inputs));
		}
		
		if (root instanceof Constant) {
			root.setInputValueOne(Double.parseDouble(inputs.get(0)));
			return root;
		}	
		//Should this be here?
		return root;
		
	}
	
	private Command controlTree(Command root, List<String> inputList) throws Exception {	
		if(root instanceof DoTimes){
			int openBracket = inputList.indexOf("[");
			int closeBracket = makeParameterList(openBracket, inputList);
			List<String> params = new ArrayList<String>();
			for(int i=openBracket+1; i < closeBracket; i ++) {
				params.add(inputList.get(i));
			}
			for(int i=openBracket+1; i < closeBracket; i ++) {
				inputList.remove(i);
			}
			DoTimes doTimes = new DoTimes();
			doTimes.setMyVariable(params.get(0));			
			doTimes.setMyMax(Double.parseDouble(params.get(1)));
			
			inputList = inputList.subList(openBracket, closeBracket);
			lexer(inputList);
			
		}
		
		if(root instanceof For) {
			int openBracket = inputList.indexOf("[");
			int closeBracket = makeParameterList(openBracket, inputList);
			List<String> params = new ArrayList<String>();
			for(int i=openBracket+1; i < closeBracket; i ++) {
				params.add(inputList.get(i));
			}
			for(int i=openBracket+1; i < closeBracket; i ++) {
				inputList.remove(i);
			}
			For forLoop = new For();
			forLoop.setMyVariable(params.get(0));			
			forLoop.setMyValue(Double.parseDouble(params.get(1)));
			forLoop.setMyMax(Double.parseDouble(params.get(2)));
			
			inputList = inputList.subList(openBracket, closeBracket);
			lexer(inputList);
			
		}
		
		if(root instanceof Repeat) {
			int openBracket = inputList.indexOf("[");
			int closeBracket = makeParameterList(openBracket, inputList);
			List<String> params = new ArrayList<String>();
			for(int i=openBracket+1; i < closeBracket; i ++) {
				params.add(inputList.get(i));
			}
			for(int i=openBracket+1; i < closeBracket; i ++) {
				inputList.remove(i);
			}
			Repeat repeat = new Repeat();
			repeat.setMyExpression(params.get(0));			
			inputList = inputList.subList(openBracket, closeBracket);
			lexer(inputList);
		}
		
		return root;
		
	}
	
	private int makeParameterList(int firstBracket, List<String> inputList) {
		int bcount = 1;
		
		for(int i=firstBracket+1; i < inputList.size(); i ++) {
			if (bcount <= 0) {
				return i;
			}
			if (inputList.get(i).equals("]")){
				i--;
			}
			if(inputList.get(i).equals("[")) {
				i++;
			}
			else {
				continue;
			}
		}
		
		return 1;
	
}
	
	/**
	 * Creates a class from a string. If its a variable, make it of type variable
	 * and add its name to a map in model which maps the variable name (including
	 * the ':' to the value (which is set by default to 0.
	 * Otherwise a new command is created based on the String passed.
	 * @param className
	 * @return A class that is a subclass of Command, based off of the string given.
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	private Command getClass(String className) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		//check if it starts with ':' if so its a variable
		Command xyz;
		if (className.charAt(0) == ':') {
			xyz = new Variable(className);
			myModel.getVariableMap().put(xyz, 0.0);
		} 
		
		else {
			xyz = (Command) Class.forName(toClass(className)).newInstance();
		}
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
