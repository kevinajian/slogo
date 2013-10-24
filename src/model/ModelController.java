package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import commands.Command;
import controller.Controller;
import parser.Parser;
import model.Model;

/**
 * Controller for all models
 * @author Kevin 
 *
 */
public class ModelController {
	private Map<Integer, Model> myModelMap = new HashMap<Integer, Model>();
	private Parser myParser;
	private Controller myController;
	
	/**
	 * creates parser, initial model
	 */
	public void initiate() {
		Parser p = new Parser();
		myParser = p;
		p.setModelController(this);
		Model model = new Model(Constants.DEFAULT_MODEL);
		myModelMap.put(model.getId(), model);
		for (Model m: getModels()) {
			m.initiate();
		}
	}
	
	/**
	 * 
	 * @param input
	 * @return
	 */
	public List<Command> parse(String input) {
		List<String> inputs = myParser.parse(input);
		List<Command> commands = myParser.lexer(inputs);
		for (Model m: myModelMap.values()) {
			m.setCommands(commands);
		}
		return commands;
	}
	
	public Map<String, Double> getCustomCommandMap() {
		return myModelMap.get(Constants.DEFAULT_MODEL).getVariableMap();
	}
	
	public void setCustomCommandMap(Map<String, Double> customCommandMap) {
		for (Model m: myModelMap.values()) {
			m.setVariableMap(customCommandMap);
		}
	}
	
	public void setCustomCommand(String key, double value) {
		for (Model m: myModelMap.values()) {
			m.addVariable(key, value);
		}
	}
	
	public double getCustomCommandValue(String key) {
		return myModelMap.get(Constants.DEFAULT_MODEL).getVariable(key);
	}
	
	public Model getModel() {
		return myModelMap.get(Constants.DEFAULT_MODEL);
	}
	
	public Map<Integer, Model> getModelMap() {
		return myModelMap;
	}
	
	public Collection<Model> getModels() {
		return myModelMap.values();
	}
	

	public void setModelMap(Map<Integer, Model> models) {
		myModelMap = models;
	}
	
	public void addModel(int id, Model m) {
		myModelMap.put(id, m);
	}
	
	public String getLanguage() {
		return myParser.getLanguage();
	}
	
	public void setLanguage(String language) {
		myParser.setLanguage(language);
	}
	
	public Parser getParser() {
		return myParser;
	}
	
	public void setParser(Parser p) {
		myParser = p;
	}

	public void sendError(String invalid) {
		myController.sendWarning(invalid);		
	}
	
	public void setController(Controller c) {
		myController = c;
	}
}
