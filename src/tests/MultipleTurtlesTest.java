package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.Model;
import model.State;

import org.junit.Test;

import commands.basic_syntax.Constant;
import commands.turtle_commands.Forward;
import controller.Controller;
import parser.Parser;
import view.View;

public class MultipleTurtlesTest {

	@Test
	public void testTell() throws Exception {
		Model model = new Model(1);
		Map<Integer, Model> modelMap = new HashMap<Integer, Model>();
		modelMap.put(model.getId(), model);
		Parser p = new Parser(modelMap);
		p.parse("Tell [ 2 ]");
		modelMap = p.getModels();
		Collection<Model> models = modelMap.values();
		for (Model m: modelMap.values()) {
			m.createStates();
			System.out.println("id: "+m.getId()+ " is active: "+m.getActive());
		}
		assertEquals()
		p.parse("Tell [ 1 2 ]");
		for (Model m: modelMap.values()) {
			m.createStates();
			System.out.println("id: "+m.getId()+ " is active: "+m.getActive());
		}
		p.parse("Tell [ 1 2 5 ]");
		for (Model m: modelMap.values()) {
			m.createStates();
			System.out.println("id: "+m.getId()+ " is active: "+m.getActive());
		}
		p.parse("Tell [ 3 4 ]");
		for (Model m: modelMap.values()) {
			m.createStates();
			System.out.println("id: "+m.getId()+ " is active: "+m.getActive());
		}
	}
	
	
}