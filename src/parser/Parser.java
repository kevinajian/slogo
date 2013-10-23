package parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import model.Constants;
import model.Model;
import commands.Command;
import commands.CommandList;
import commands.basic_syntax.Constant;
import commands.basic_syntax.Variable;
import commands.multiple_turtles.*;
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
	private Map<Integer, Model> myModels;
	private String myLanguage = Constants.DEFAULT_LANGUAGE;
	private String name;
	
	public Parser(Map<Integer, Model> models){
		myModels = models;
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
		if(list.length>1){
			name = list[1];
		}
		if(list[1].equals("OnClick") || list[1].equals("OnKey")){
			list[1] = "";
		}
		System.out.println(list[1]);
		List<String> inputs = new ArrayList<String>();
		parseArrayToArrayList(inputs, list);
		
		if (inputs.get(0) == null) {
			String outString = customCommandHandler(input);
			String[] toInputs = outString.split(Constants.INPUT_SPLITTER);
			parseArrayToArrayList(inputs, toInputs);
		}
		
		List<Command> commands = lexer(inputs);
		for (Model m: myModels.values()) {
			m.setCommands(commands);
		}
		
		return inputs;
	}
	/**
	 * Helper method for parse, makes an array containing string commands
	 * into an arraylist containing string commands.
	 * @param inputs
	 * @param toInputs
	 */
	private void parseArrayToArrayList(List<String> inputs, String[] toInputs) {
		for(String string : toInputs){
			if(string.matches(Constants.CONSTANT_ID) || (string.charAt(0) == Constants.VARIABLE_ID.charAt(0)) || (string.equals(Constants.OPEN_BRACKET)) || (string.equals(Constants.CLOSE_BRACKET))){
				inputs.add(string);
			}
			else{
				inputs.add(fileToMap(getLanguage()).get(string.toUpperCase()));
			}
		}
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
			Command headNode = getClass(inputs.get(0));
			if (headNode instanceof CommandList) {
				inputs.remove(0);
				specialTreeBuilder(headNode, inputs);
			}
			else if (headNode instanceof To) {
				((To) headNode).setName(name);
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
	
	public Command specialTreeBuilder(Command root, List<String> inputs) throws Exception {
		if (root instanceof To) {
			inputs.remove(0);
			int openBracket = findFirstBracket(inputs);
			int closeBracket = findLastBracket(openBracket, inputs);
			List<String> params = listBuilder(openBracket+1, closeBracket-1, inputs);
			inputs.remove(0); inputs.remove(0);
			setCommandList(root, inputs);
		}
		else if (root instanceof For) {
			int openBracket = findFirstBracket(inputs);
			if (root instanceof Repeat) {
				List<String> params = listBuilder(0, openBracket-1, inputs);
				setParams(root, params);
				setCommandList(root, inputs);
				return root;
			}
			int closeBracket = findLastBracket(openBracket, inputs);
			List<String> params = listBuilder(openBracket+1, closeBracket-1, inputs);
			setParams(root, params);
			inputs.remove(0); inputs.remove(0);
			setCommandList(root, inputs);
		}
		else if (root instanceof Tell) {
			Set<Integer> turtles = myModels.keySet();
			List<String> turtleSet;
			if (root instanceof TellEven) {
				turtleSet = new ArrayList<String>();
				for (Integer i: turtles) {
					if ((i%2) == 0) {
						turtleSet.add(i.toString());
					}
				}
			}
			else if (root instanceof TellOdd) {
				turtleSet = new ArrayList<String>();
				for (Integer i: turtles) {
					if ((i%2) != 0) {
						turtleSet.add(i.toString());
					}
				}
			}
			else {
				int openBracket = findFirstBracket(inputs);
				int closeBracket = findLastBracket(openBracket, inputs);
				turtleSet = listBuilder(openBracket+1, closeBracket-1, inputs);
				inputs.remove(0); inputs.remove(0);
				if (root instanceof AskWith) {
					List<Command> expression = lexer(turtleSet);
					((AskWith) root).setExpression(expression.get(0));
				}
				else {
					for (String s: turtleSet) {
						if (!turtles.contains(Integer.parseInt(s))) {
							Model m = new Model(Integer.parseInt(s));
							m.initiate();
							myModels.put(m.getId(), m);
						}
					}
				}
				if (root instanceof Ask) {
					setCommandList(root, inputs);
				}
			}
			((Tell) root).setTurtles(turtleSet);
		}
		else if (root instanceof If) {
			int openBracket = findFirstBracket(inputs);
			List<String> expressionList = listBuilder(0, openBracket -1, inputs);
			List<Command> expression = lexer(expressionList);
			((If) root).setExpression(expression.get(0));
			setCommandList(root, inputs);
			if (root instanceof IfElse) {
				openBracket = findFirstBracket(inputs);
				int closeBracket = findLastBracket(openBracket, inputs);
				List<String> inputList = listBuilder(openBracket+1, closeBracket-1, inputs);
				((IfElse) root).setCommandList2(lexer(inputList));
				inputs.remove(0);inputs.remove(0);
			}
		}
		return root;
	}
	
	public void setCommandList(Command root, List<String> inputs) throws Exception {
		int openBracket = findFirstBracket(inputs);
		int closeBracket = findLastBracket(openBracket, inputs);
		List<String> inputList = listBuilder(openBracket+1, closeBracket-1, inputs);
		if (root instanceof CommandList) {
			((CommandList) root).setCommandList(lexer(inputList));
		}
		else if (root instanceof To) {
			String commandString = "";
			for(String str : inputList){
				commandString += str + " ";
			}
			((To) root).setCommands(commandString);
		}
		inputs.remove(0);inputs.remove(0);
	}

	public void setParams(Command root, List<String> params) throws Exception {
		if (root instanceof Repeat) {
			Command variable = new Variable(":repcount");
			setCustomCommand(((Variable) variable).getVariableName(), Constants.DEFAULT_ITERATION);
			((For) root).setVariable((Variable) variable);
			((For) root).setMax((int) lexer(params).get(0).evaluate(myModels.get(0)));
			((For) root).setIncrement(Constants.DEFAULT_INCREMENT);
			return;
		}
		Command variable = getClass(params.get(0));
		if (root instanceof DoTimes) {
			setCustomCommand(((Variable) variable).getVariableName(), Constants.DEFAULT_ITERATION);
			((For) root).setVariable((Variable) variable);
			((For) root).setMax(Integer.parseInt(params.get(1)));
			((For) root).setIncrement(Constants.DEFAULT_INCREMENT);
			return;
		}
		int start = Integer.parseInt(params.get(1));
		setCustomCommand(((Variable) variable).getVariableName(), start);
		((For) root).setVariable((Variable) variable);
		((For) root).setMax(Integer.parseInt(params.get(2)));
		((For) root).setIncrement(Integer.parseInt(params.get(3)));	
	}

	public List<String> listBuilder(int firstIndex, int endIndex, List<String> inputs) {
		List<String> returnList = new ArrayList<String>();
		for (int i = firstIndex; i <=endIndex ; i++) {
			returnList.add(inputs.get(i));
		}
		removeRange(firstIndex, endIndex, inputs);
		return returnList;
	}
	
	public void removeRange(int firstIndex, int endIndex, List<String> inputs) {
		for (int i=firstIndex; i<=endIndex; i++){
			inputs.remove(firstIndex);
		}
	}
	
	
	public int findFirstBracket(List<String> inputList) {
		for (int i=0; i < inputList.size(); i++) {
			if (inputList.get(i).equals(Constants.OPEN_BRACKET)) {
				return i;
			}
		}
		return 0;
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
	public Command getClass(String className) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		//check if it starts with ':' if so its a variable
		System.out.println("get class className: "+className);
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
	 * Deals with custom commands from a command map
	 * and sends them through to the parser.
	 * Takes a commandstring if its first element was found not
	 * to be a valid class, and pulls it out of the custom command
	 * map, puts the value of the command in a string and replaces
	 * all of the parameters
	 */
	public String customCommandHandler(String commandString) {
		commandString.toUpperCase();
		String [] commandList = commandString.split(Constants.INPUT_SPLITTER);
		ArrayList<Integer> valuesList = new ArrayList<Integer>(); 
		//making parameter values into ints and adding to list
		for(int i=1; i<commandList.length; i++) {
			valuesList.add(Integer.parseInt(commandList[i]));
		}
		for (Model m:myModels.values()) {
			if (m.getCustomCommandMap().containsKey(commandList[0])) {
				String out = m.getCustomCommandMap().get(commandList[0]);
				for(int i=0; i < valuesList.size(); i++) {
					out = out.replaceFirst(":[\\w*]", valuesList.get(i).toString());
				}
				return out;
			}
		}
		return commandString;
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

	public void initiate() {
		for (Model m:myModels.values()) {
			m.initiate();
		}
	}
	
	public Map<String, Double> getCustomCommandMap() {
		return myModels.get(1).getVariableMap();
	}

	public void setCustomCommandMap(Map<String, Double> customCommandMap) {
		for (Model m: myModels.values()) {
			m.setVariableMap(customCommandMap);
		}
	}
	
	public void setCustomCommand(String key, double value) {
		for (Model m: myModels.values()) {
			m.addVariable(key, value);
		}
	}
	
	public double getCustomCommandValue(String key) {
		return myModels.get(1).getVariable(key);
	}
	
	public Map<Integer, Model> getModels() {
		return myModels;
	}
	
	public void setModels(Map<Integer, Model> models) {
		myModels = models;
	}
	
	public String getLanguage() {
		return myLanguage;
	}

	public void setLanguage(String language) {
		myLanguage = language;
	}
	public Model getModel(){
		return myModels.get(Constants.DEFAULT_MODEL);
	}
}