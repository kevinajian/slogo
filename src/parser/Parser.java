package parser;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Parses user input
 * @author Kevin, Carlos
 *
 */
public class Parser {
	private String[] myList;
	
	public Parser(){
	}
	
	/**
	 * splits user input and passes results to lexer
	 * @param input - String of user input
	 */
	public void parse(String input){
		String [] list = input.split("\\s+");
		lexer(list);
	}
	
	/**
	 * creates classes from list of user input
	 * @param list - String[] of user input
	 */
	private void lexer(String[] input){
		for (String string:input){
			
		}
	}
	
	
	static String in = "fd fd 50";
	static List<String> commandList = new ArrayList<String>();

	public static void tokenizer (String input) {
		
		StringTokenizer st = new StringTokenizer(input);
		
		while (st.hasMoreTokens()) {
			commandList.add(st.nextToken());
		} 
		
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		String clsName = "Forward";  // use fully qualified name
		Class<?> cls = null;
		try {
			cls = Class.forName(clsName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object clsInstance = (Object) cls.newInstance();
		//tokenizer(in);
	}
}
