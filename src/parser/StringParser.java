package parser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import model.Model;
import commands.Command;
import commands.NInputs;
import commands.OneInput;
import commands.TwoInput;
import commands.turtle_commands.Forward;
import commands.Constant;
import java.lang.Throwable;



public class StringParser {
	private List<Command> commandList = new ArrayList<Command>();
	private Model myModel;
	
	public StringParser(Model model){
		myModel = model;
	}
	
	/**
	 * splits user input and passes results to lexer
	 * @param input - String of user input
	 * @throws Exception 
	 */
	List<String> inputs;
	public void parse(String input) throws Exception{
		input.toUpperCase();
		String [] list = input.split("\\s+");
		inputs = new ArrayList<String>();
		
		for (String item:list){
			inputs.add(item);
		}
		//lexer(inputs);
	}
	
	/**
	 * creates Command objects from user input, executes the commands as soon as they are found,
	 * traversing the array of split strings from back to front. The commands are executed based
	 * on how many input statements they take, they are executed, and the return values are 
	 * placed back in the list of commands as strings where they were taken out.
	 * @param inputs - List<String> of user input 
	 * @throws Exception 
	 */
	
	
	private static void treeBuilder(Node root) throws Exception{
		Constant constant = new Constant();
		constant.setMyValue(Double.parseDouble("20"));
		root.getMyLeftChild().myCommand = constant;
		root.getMyRightChild().myCommand = constant;
		
		if (root.getMyCommand() instanceof OneInput) {
			root.myLeftChild = new Node(constant, null, null);
			treeBuilder(root.myLeftChild);
		}
		
		if (root.getMyCommand() instanceof TwoInput) {
			root.myLeftChild = new Node(constant, null, null);
			treeBuilder(root.myLeftChild);
			root.myRightChild = new Node(constant, null, null);
			treeBuilder(root.myRightChild);

			
		}
		
		if (root.getMyCommand() instanceof Constant) {
			
		}
		
	}
	
	
	private static Command getClass(String className) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Command xyz = (Command) Class.forName(toClass(className)).newInstance();
		return xyz;
	}

	private static final String PATH = "commands.sum";
	
	public static String toClass(String in) {
		return PATH + in;
	}
	
	
	public static void main(String[] args) throws Exception {
		String s = "SUM 20 40";
		ArrayList<String> in = new ArrayList<String>(); 
		in.add("SUM"); in.add("20"); in.add("40");
		Node root = new Node(getClass(in.get(0)), null, null);
		treeBuilder(root);

	}
}
