package parser;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Parser {
	
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
