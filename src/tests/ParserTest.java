package tests;

import static org.junit.Assert.*;

import model.Model;

import org.junit.Test;

import parser.Parser;

public class ParserTest {

	@Test
	public void testToClass() {
		Model model = new Model();
		Parser parser = new Parser(model);
		System.out.println(parser.toClass("Back"));
		assertEquals(parser.toClass("Forward"), "commands.turtle_commands.Forward");
		assertEquals(parser.toClass("Sum"), "commands.math.Sum");
		assertEquals(parser.toClass("Constant"), "commands.basic_syntax.Constant");

	}
	
//	@Test
//	public void testParser() throws Exception {
//		Model model = new Model();
//		Parser parser = new Parser(model);
//		String inputString = "SUM 3 4";
//		parser.parse(inputString);

//	}
	
	
}
