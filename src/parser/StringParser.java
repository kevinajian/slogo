package parser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

import model.Model;
import commands.Command;
import commands.vcu.ControlStructure;
import commands.NInputs;
import commands.OneInput;
import commands.TwoInput;
import commands.basic_syntax.Constant;
import commands.turtle_commands.Forward;
import java.lang.Throwable;



public class StringParser {
	private List<String> inputs;
	private Model myModel;
	
	public StringParser(Model model){
		myModel = model;
	}
	
	/**
	 * splits user input and passes results to lexer
	 * @param input - String of user input
	 * @throws Exception 
	 */
	public void parse(String input) throws Exception{
		input.toUpperCase();
		String [] list = input.split("\\s+");
		
		for (String item:list){
			inputs.add(item);
		}
		lexer(inputs);
	}
	
	private void lexer(List<String> inputs) throws Exception{
		List<Command> rootList = new ArrayList<Command>();
		
		while(!rootList.isEmpty()) {
			Command headNode = getClass(inputs.get(0));
			treeBuilder(headNode);
			inputs.remove(0);
			rootList.add(headNode);
		}
	}
		
	private Command treeBuilder(Command root) throws Exception{
		
//		if (root.getMyCommand() instanceof ControlStructure){
//			Queue queue = new Queue();
//		}
		
		if (root instanceof OneInput) {
			Command curr = getClass(inputs.get(1));
			inputs.remove(0);
			root.myLeftChild = treeBuilder(curr);
		}
		
		if (root instanceof TwoInput) {
			Command curr = getClass(inputs.get(1));
			inputs.remove(0);
			root.myLeftChild = treeBuilder(curr);
			
			curr = getClass(inputs.get(1));
			inputs.remove(0);
			root.myRightChild = treeBuilder(curr);
		}
		
		if (root instanceof Constant) {
			root.myValue = Double.parseDouble(inputs.get(0));
			return root;
		}
		
	}
	
	
	private static Command getClass(String className) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Command xyz = (Command) Class.forName(toClass(className)).newInstance();
		return xyz;
	}
	
	public static String toClass(String in) {
		return PATH + in;
	}
	
	
}
