package parser;

import java.util.ArrayList;
import java.util.List;
import model.Model;
import commands.Command;
import commands.NInputs;
import commands.basic_syntax.Constant;



public class Parser {
	private List<String> inputs;
	private Model myModel;
	
	public Parser(Model model){
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

		//was instance of TwoInputs
		if (root instanceof NInputs) {
			Command curr = getClass(inputs.get(1));
			inputs.remove(0);
			root.setLeftChild(treeBuilder(curr));
			
			curr = getClass(inputs.get(1));
			inputs.remove(0);
			root.setRightChild(treeBuilder(curr));
		}

		//was instance of OneInput
		if (root instanceof Command) {
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
	
	private Command getClass(String className) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Command xyz = (Command) Class.forName(toClass(className)).newInstance();
		return xyz;
	}
	
	public String toClass(String in) {
		FindFilePath filePath = new FindFilePath(in);
		return filePath.makePath();
	}
	
	
}
