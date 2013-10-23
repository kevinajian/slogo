package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.Model;
import model.ModelController;
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
		ModelController mc = new ModelController();
		mc.initiate();
		Map<Integer, Model> modelMap = mc.getModelMap();
		mc.parse("Tell [ 2 ]");
		for (Model m: modelMap.values()) {
			m.createStates();
			System.out.println("id: "+m.getId()+ " is active: "+m.getActive());
		}
		mc.parse("Tell [ 1 2 ]");
		for (Model m: modelMap.values()) {
			m.createStates();
			System.out.println("id: "+m.getId()+ " is active: "+m.getActive());
		}
		mc.parse("Tell [ 1 2 5 ]");
		for (Model m: modelMap.values()) {
			m.createStates();
			System.out.println("id: "+m.getId()+ " is active: "+m.getActive());
		}
		mc.parse("Tell [ 3 4 ]");
		for (Model m: modelMap.values()) {
			m.createStates();
			System.out.println("id: "+m.getId()+ " is active: "+m.getActive());
		}
	}

	@Test
	public void testTellEven() throws Exception {
		ModelController mc = new ModelController();
		mc.initiate();
		Collection<Model> models = mc.getModels();
		mc.parse("Tell [ 1 2 3 4 5 6 ]");
		for (Model m: models) {
			m.createStates();
			System.out.println("id: "+m.getId()+ " is active: "+m.getActive());
		}
		models = mc.getModels();
		mc.parse("TellEven");
		for (Model m: models) {
			m.createStates();
			System.out.println("id: "+m.getId()+ " is active: "+m.getActive());
		}
	}
	
	@Test
	public void testTellOdd() throws Exception {
		ModelController mc = new ModelController();
		mc.initiate();
		Collection<Model> models = mc.getModels();
		mc.parse("Tell [ 1 2 3 4 5 6 ]");
		for (Model m: models) {
			m.createStates();
			System.out.println("id: "+m.getId()+ " is active: "+m.getActive());
		}
		
		models = mc.getModels();
		mc.parse("TellOdd");
		for (Model m: models) {
			m.createStates();
			System.out.println("id: "+m.getId()+ " is active: "+m.getActive());
		}
	}
	
}