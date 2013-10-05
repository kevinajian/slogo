package parser;

import java.util.ArrayList;
import java.util.List;

/**
 * Parses user input
 * @author Kevin
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
	
}
