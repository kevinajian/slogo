package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Model;
import model.State;

import org.junit.Test;

import commands.*;
import commands.math.*;
import commands.turtle_commands.*;
import commands.turtle_queries.*;
import commands.vcu.For;
import parser.Parser;

public class ParserTest {

	@Test
	public void testToClass() {
		Model model = new Model(1);
		Map<Integer, Model> models = new HashMap<Integer, Model>();
		models.put(model.getId(), model);
		Parser parser = new Parser(models);
		Forward fd = new Forward();
		assertEquals(parser.toClass("Forward"), "commands.turtle_commands.Forward");
		assertEquals(parser.toClass("Sum"), "commands.math.Sum");
		assertEquals(parser.toClass("Constant"), "commands.basic_syntax.Constant");
	}

	@Test
	public void testGetClass() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Model model = new Model(1);
		Map<Integer, Model> models = new HashMap<Integer, Model>();
		models.put(model.getId(), model);
		Parser parser = new Parser(models);
		Command test = parser.getClass("Back");
		assertTrue(test instanceof Back);
		Command test2 = parser.getClass("And");
		assertTrue(test2 instanceof And);
		Command test3 = parser.getClass("Remainder");
		assertTrue(test3 instanceof Remainder);
		Command test4 = parser.getClass("Heading");
		assertTrue(test4 instanceof Heading);
	}
	
	@Test
	public void testTreeBuilder() throws Exception {
		Model model = new Model(1);
		Map<Integer, Model> models = new HashMap<Integer, Model>();
		models.put(model.getId(), model);
		Parser parser = new Parser(models);
		List<String> testInputs = new ArrayList<String>(){{add("Forward"); add("50");}};
		Command test1 = parser.getClass("Forward");
		assertTrue(test1 instanceof Forward);
		parser.treeBuilder(test1, testInputs);
		assertEquals(test1.getInputValueOne(model), 50.0, 0.0);
		
		List<String> testInputs2 = new ArrayList<String>(){{add("Sum"); add("3"); add("5");}};
		Command test2 = parser.getClass("Sum");
		assertTrue(test2 instanceof Sum);
		parser.treeBuilder(test2, testInputs2);
		assertEquals(test2.getInputValueOne(model), 3.0, 0.0);
		assertEquals(test2.getInputValueTwo(model), 5.0, 0.0);
		assertEquals(test2.evaluate(model), 8.0, 0.0);
	}
	
	@Test
	public void testLexer() {
		Model model = new Model(1);
		Map<Integer, Model> models = new HashMap<Integer, Model>();
		models.put(model.getId(), model);
		Parser parser = new Parser(models);
		List<String> testInputs = new ArrayList<String>(){{add("Forward"); add("50"); add("Sum"); add("3"); add("5");}};
		List<Command> testOutput = null;
		try {
			testOutput = parser.lexer(testInputs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Command test1 = testOutput.get(0);
		assertTrue(test1 instanceof Forward);
		assertEquals(test1.getInputValueOne(model), 50.0, 0.0);
		model.addState(new State(0.0, 0.0, 0.0, "1", "1", "Black"));
		test1.evaluate(model);
		assertEquals(model.getX(), 0.0, 0.0);
		assertEquals(model.getY(), 50.0, 0.0);
		
		Command test2 = testOutput.get(1);
		assertEquals(test2.getInputValueOne(model), 3.0, 0.0);
		assertEquals(test2.getInputValueTwo(model), 5.0, 0.0);
		assertEquals(test2.evaluate(model), 8.0, 0.0);
	}
	
	@Test
	public void testParse() {
		Model model = new Model(1);
		Map<Integer, Model> models = new HashMap<Integer, Model>();
		models.put(model.getId(), model);
		Parser parser = new Parser(models);
		String testInputs = "Forward 50 Sum 3 5";
		List<String> testOutput = null;
		try {
			testOutput = parser.parse(testInputs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (String s:testOutput){
			System.out.println(s);
		}
		assertTrue(testOutput.isEmpty());
	}
	
	@Test
	public void testBracket() throws Exception{
		Model model = new Model(1);
		Map<Integer, Model> models = new HashMap<Integer, Model>();
		models.put(model.getId(), model);
		Parser parser = new Parser(models);
		String testInputs = "[abcd]";
		List<String> inputs = new ArrayList<String>();
		for (int i=0; i<testInputs.length(); i++) {
			inputs.add(testInputs.substring(i,i+1));
		}
		int closingBracket = parser.findLastBracket(0, inputs);
		assertEquals(closingBracket, 5);
		
		testInputs = "[[[[[]]]]]";
		inputs.clear();
		for (int i=0; i<testInputs.length(); i++) {
			inputs.add(testInputs.substring(i,i+1));
		}
		closingBracket = parser.findLastBracket(0, inputs);
		assertEquals(closingBracket, testInputs.length()-1);
	}
	
	@Test
	public void testRemoveRange() {
		Model model = new Model(1);
		Map<Integer, Model> models = new HashMap<Integer, Model>();
		models.put(model.getId(), model);
		Parser parser = new Parser(models);
		List<String> inputs = new ArrayList<String>() {{add("["); add("a"); add("b"); add("c"); add("]");}};
		parser.removeRange(0, inputs.size()-1, inputs);
		assertTrue(inputs.isEmpty());
	}
	
	@Test
	public void testListBuilder() {
		Model model = new Model(1);
		Map<Integer, Model> models = new HashMap<Integer, Model>();
		models.put(model.getId(), model);
		Parser parser = new Parser(models);
		List<String> inputs = new ArrayList<String>() {{add("["); add("a"); add("b"); add("c"); add("]"); add("end");}};
		int openBracket = 0;
		int closeBracket = parser.findLastBracket(0, inputs);
		List<String> test = parser.listBuilder(openBracket, closeBracket, inputs);
		assertEquals(test.get(1), "a");
		assertEquals(test.get(2), "b");
		assertEquals(test.get(3), "c");
	}
	
	@Test
	public void testSetParams() throws Exception {
		Model model = new Model(1);
		Map<Integer, Model> models = new HashMap<Integer, Model>();
		models.put(model.getId(), model);
		Parser parser = new Parser(models);
		Command testRoot = new For();
		List<String> inputs = new ArrayList<String>() {{add(":x"); add("0"); add("5"); add("1");}};
		parser.setParams(testRoot, inputs);
		assertEquals(((For) testRoot).getVariable().getVariableName(), ":x");
		assertEquals(model.getCustomCommandValue(((For) testRoot).getVariable().getVariableName()), 0.0, 0.0);
		assertEquals(((For) testRoot).getMax(), 5.0, 0.0);
		assertEquals(((For) testRoot).getIncrement(), 1);
	}
	
	@Test
	public void testSpecialTreeBuilderFor() throws Exception {
		Model model = new Model(1);
		Map<Integer, Model> models = new HashMap<Integer, Model>();
		models.put(model.getId(), model);
		Parser parser = new Parser(models);
		Command testRoot = new For();
		List<String> inputs = new ArrayList<String>() {{add("["); add(":x"); add("0"); add("5"); add("1"); add("]"); add("["); add("Forward"); add("50"); add("]");}};
		parser.specialTreeBuilder(testRoot, inputs);
		System.out.println("variable value: "+model.getCustomCommandValue(((For) testRoot).getVariable().getVariableName()) + " max value: " + ((For) testRoot).getMax());
		List<Command> test = ((For) testRoot).getCommandList();
		System.out.println(test.get(0).getClass());
		System.out.println(test.get(0).getInputValueOne(model));
		model.addState(new State(0.0, 0.0, 0.0, "1", "1", "Black"));
		testRoot.evaluate(model);
		assertEquals(model.getY(), 250.0, 0.0);
	}
	
	@Test
	public void testSpecialTreeBuilderTell() throws Exception {
		Model model = new Model(1);
		Map<Integer, Model> models = new HashMap<Integer, Model>();
		models.put(model.getId(), model);
		Parser parser = new Parser(models);
		Command testRoot = new For();
	}
}