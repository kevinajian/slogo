package parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import model.Constants;
import model.Model;
import commands.Command;
import commands.basic_syntax.Constant;
import commands.basic_syntax.Variable;
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
	
	public Map<String, String> fileToMap(String filename) {
		Map<String, String> propertiesMap = new HashMap<String, String>();
		
	    FileReader reader = null;
		try {
			reader = new FileReader(filename);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}		
	    
		Properties properties = new Properties();
	    try {
	        properties.load(reader);
	      }
	      catch (Exception e) {

	      }
		
		for (String key : properties.stringPropertyNames()) {
		    String value = properties.getProperty(key);
		    propertiesMap.put(key, value);
		}
		return propertiesMap;
	}
	
	/**
	 * Splits user input and passes results to lexer
	 * @param input - String of user input
	 * @throws Exception 
	 */
	public List<String> parse(String input) throws Exception{
		input.toUpperCase();
		String [] list = input.split(Constants.INPUT_SPLITTER);
		List<String> inputs = new ArrayList<String>();
		for(String string : list){
			if(string.matches("-?\\d+(\\.\\d+)?")){
				inputs.add(string);
			}
			if(string.charAt(0) == ':') {
				inputs.add(string);
			}
			else{
				inputs.add(fileToMap(myModel.getMyLanguage()).get(string.toUpperCase()));
			}
		}
		myModel.setCommands(lexer(inputs));
		return inputs;
	}
	
	/**
	 * Makes a list of trees by storing their root, loops over
	 * all commands tokenized by the parse method, and calls
	 * treebuilder, putting the root in an array of roots.
	 * @param inputs
	 * @throws Exception
	 */
	public List<Command> lexer(List<String> inputs) throws Exception{
		List<Command> rootList = new ArrayList<Command>();
		inputs.removeAll(Collections.singleton(null));
		while(inputs.size() >= 1) {
			System.out.println(inputs);
			Command headNode = getClass(inputs.get(0));
			if (headNode instanceof Loop) {
				inputs.remove(0);
				specialTreeBuilder(headNode, inputs);
			}
			else {
				treeBuilder(headNode, inputs);
				inputs.remove(0);
			}
			rootList.add(headNode);
		}
		return rootList;
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
	 public Command treeBuilder(Command root, List<String> inputs) throws Exception{

		if (root instanceof Constant) {
			root.setInputValueOne(Double.parseDouble(inputs.get(0)));
			return root;
		}	
		 
		if (root.getNumInputs() == 0) {
			return root;
		}

		if (root.getNumInputs() == 2) {
			Command curr = getClass(inputs.get(1));
			inputs.remove(0);
			root.setLeftChild(treeBuilder(curr, inputs));
			
			curr = getClass(inputs.get(1));
			inputs.remove(0);
			root.setRightChild(treeBuilder(curr, inputs));
		}

		if (root.getNumInputs() == 1) {
			Command curr = getClass(inputs.get(1));
			inputs.remove(0);
			root.setLeftChild(treeBuilder(curr, inputs));
		}
		
		return root;
	}
	
	private void specialTreeBuilder(Command root, List<String> inputs) throws Exception {
		if (root instanceof For) {
			int openBracket = 0;
			int closeBracket = findLastBracket(openBracket, inputs);
			List<String> params = listBuilder(openBracket, closeBracket, inputs);
			setForParams(root, params);
			closeBracket = findLastBracket(openBracket, inputs);
			List<String> inputList = listBuilder(openBracket, closeBracket, inputs);
			((For) root).setCommandList(lexer(inputList));
		}	
	}

	private void setForParams(Command root, List<String> params) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Command variable = getClass(params.get(0));
		int start = Integer.parseInt(params.get(1));
		myModel.addCustomCommand(((Variable) variable).getVariableName(), start);
	}

	private List<String> listBuilder(int firstIndex, int endIndex, List<String> inputs) {
		List<String> returnList = new ArrayList<String>();
		for (int i = firstIndex; i < endIndex ; i++) {
			returnList.add(inputs.get(i));
		}
		removeRange(firstIndex, endIndex, inputs);
		return returnList;
	}
	
	private void removeRange(int firstIndex, int endIndex, List<String> inputs) {
		for (int i=firstIndex; i<endIndex; i++){
			inputs.remove(firstIndex);
		}
	}
	
	public int findLastBracket(int firstBracket, List<String> inputList) {
		int bcount = 1;
		for(int i = firstBracket+1; i<inputList.size(); i++) {
			if (inputList.get(i).equals(Constants.OPEN_BRACKET)) {
				bcount++;
			}
			else if (inputList.get(i).equals(Constants.CLOSE_BRACKET)) {
				bcount--;
			}
			if (bcount <= 0) {
				return i;
			}
		}
		return 0;
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
	public Command getClass(String className) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		//check if it starts with ':' if so its a variable
		Command xyz;
		if (className.matches(Constants.CONSTANT_ID)) {
			xyz = new Constant();
			xyz.setInputValueOne(Double.parseDouble(className));
		}
		else if (className.charAt(0) == Constants.VARIABLE_ID.charAt(0)) {
			xyz = new Variable(className);
		} 
		else {
			xyz = (Command) Class.forName(toClass(className)).newInstance(); // IF THIS ISN"T FOUND WE SHOULD RETURN AT ERROR. 
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
