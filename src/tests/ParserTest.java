package tests;

import static org.junit.Assert.*;

import model.Model;

import org.junit.Test;

import parser.Parser;

public class ParserTest {

	@Test
	public void testMakePath() {
		Model model = new Model();
		Parser parser = new Parser(model);
		assertEquals(parser.toClass("Forward"), "commands.turtle_commands.Forward");
		assertEquals(parser.toClass("Sum"), "commands.math.Sum");
		assertEquals(parser.toClass("Constant"), "commands.basic_syntax.Constant");


	}

}
