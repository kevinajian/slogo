package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import model.Model;

import org.junit.Test;

import commands.*;
import commands.math.*;
import commands.turtle_commands.*;
import commands.turtle_queries.*;
import parser.Parser;

public class ParserTest {

	@Test
	public void testToClass() {
		Model model = new Model();
		Parser parser = new Parser(model);
		Forward fd = new Forward();
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

	@Test
	public void testGetClass() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Model model = new Model();
		Parser parser = new Parser(model);
		Command test = parser.getClass("Back");
		assertTrue(test instanceof Back);
		Command test2 = parser.getClass("And");
		assertTrue(test2 instanceof And);
		Command test3 = parser.getClass("Remainder");
		assertTrue(test3 instanceof Remainder);
//		Command test4 = parser.getClass("Heading");
//		assertTrue(test4 instanceof Heading);

	}
	
	@Test
	public void testTreeBuilder() throws Exception {
		Model model = new Model();
		Parser parser = new Parser(model);
		List<String> testInputs = new ArrayList<String>(){{add("Forward"); add("50");}};
		Command test = parser.getClass("Forward");
		assertTrue(test instanceof Forward);
		parser.treeBuilder(test, testInputs);
//		System.out.println(fd.getInputValueOne());
//		assertEquals(fd.getInputValueOne(), 50.0, 0.0);
	}
	
}
