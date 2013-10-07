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
		lexer(inputs);
	}
	
	private void lexer(List<String> inputs) throws Exception{
		List<Node> rootList = new ArrayList<Node>();
		
		while(!rootList.isEmpty()) {
			Node headNode = new Node(getClass(inputs.get(0)), null, null, null, null);
			treeBuilder(headNode);
			inputs.remove(0);
			rootList.add(headNode);
		}
	}
		
	private static Node treeBuilder(Node root) throws Exception{
		
//		if (root.getMyCommand() instanceof ControlStructure){
//			Queue queue = new Queue();
//		}
		
		if (root.getMyCommand() instanceof OneInput) {
			Command curr = getClass(inputs.get(1));
			inputs.remove(0);
			root.myLeftChild = treeBuilder(new Node(curr, null, null, root, null));
		}
		
		if (root.getMyCommand() instanceof TwoInput) {
			Command curr = getClass(inputs.get(1));
			inputs.remove(0);
			root.myLeftChild = treeBuilder(new Node(curr, null, null, root, null));
			
			curr = getClass(inputs.get(1));
			inputs.remove(0);
			root.myRightChild = treeBuilder(new Node(curr, null, null, root, null));
		}
		
		if (root.getMyCommand() instanceof Constant) {
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
	
	
	public static void main(String[] args) throws Exception {
		String s = "SUM 20 40";
		ArrayList<String> in = new ArrayList<String>(); 
		in.add("SUM"); in.add("20"); in.add("40");
		Node root = new Node(getClass(in.get(0)), null, null);
		treeBuilder(root);

	}
}
