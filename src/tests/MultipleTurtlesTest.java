package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Model;
import model.State;

import org.junit.Test;

import commands.basic_syntax.Constant;
import commands.turtle_commands.Forward;
import parser.Parser;

public class MultipleTurtlesTest {

	@Test
	public void testTell() throws Exception {
		Model model = new Model(1);
		Map<Integer, Model> models = new HashMap<Integer, Model>();
		models.put(model.getId(), model);
		Parser parser = new Parser(models);
		parser.parse("Tell [ 2 ]");
		System.out.println(parser.getModels().size());
	}
}