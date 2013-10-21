package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import commands.Command;
import commands.basic_syntax.Variable;
import parser.Parser;

/**
 * interprets user input and contains state
 * @author Kevin, Carlos
 */
public class Model implements TurtleCommands, TurtleQueries, MathModel {
	
	private List<State> myStates = new ArrayList<State>();
	private State myOrigin;
	private String myTurtleVisible = Constants.TURTLE_SHOWING;
	private String myPenVisible = Constants.PEN_SHOWING;
	private List<Command> myCommands = new ArrayList<Command>();
	private Map<String, Double> customCommandMap = new HashMap<String, Double>();
	private String myLanguage = "src/parser/English.properties";
	private String myBackgroundColor = "White";
	private String myPenColor = "Black";

	public void initiate() {
		myOrigin = new State(Constants.TURTLE_XORIGIN,Constants.TURTLE_YORIGIN,Constants.TURTLE_DEGREEORIGIN, Constants.TURTLE_SHOWING, Constants.PEN_SHOWING, getPenColor());
		myStates.add(myOrigin);
	}
	
	/**
	 * gets degree of current state
	 * @return - double of current orientation
	 */
	public double getOrientation() {
		return getCurrentState().getOrientation();
	}

	/**
	 * gets x coordinate of current state
	 * @return - double of current x
	 */
	public double getX() {
		return getCurrentState().getX();
	}

	/**
	 * gets y coordinate of current state
	 * @return - double of current y
	 */
	public double getY() {
		return getCurrentState().getY();
	}
	
	/**
	 * add state to states list
	 * @param state - state to be added
	 */
	public void addState(State state) {
		//System.out.println("model.addState");
		myStates.add(state);	
	}

	/**
	 * gets states that the turtle has traveled
	 * @return - List of Lines that make trail
	 */
	public List<State> getStates() {
		return myStates;
	}
	
	public void createStates() {
		//System.out.println("model.createStates");
		for (Command c:myCommands){
			//System.out.println("command num inputs: "+c.getNumInputs());
			c.evaluate(this);
		}
	}
	
	public void resetModel() {
		myCommands.clear();
		myStates.clear();
		myStates.add(myOrigin);
	}

	/**
	 * get current state of the turtle
	 * @return - State of turtle
	 */
	public State getCurrentState() {
		return myStates.get(myStates.size()-1);
	}
	
	public List<Command> getCommands() {
		return myCommands;
	}
	
	public void setCommands(List<Command> commands) {
		myCommands = commands;
	}
	
	/**
	 * processes user input, sends through parser
	 * @param input - user input
	 * @throws Exception 
	 */
	public void processString(String input) throws Exception {
		Parser parser = new Parser((this));
		parser.parse(input);
	}
	
	public String getPenVisible() {
		return myPenVisible;
	}

	public void setPenVisible(String penVisible) {
		myPenVisible = penVisible;
	}
	
	public String getTurtleVisible() {
		return myTurtleVisible;
	}
	
	/**
	 * sets the visibility of the turtle
	 * @param turtleVisible - new visibility of turtle
	 */
	public void setTurtleVisible(String turtleVisible) {
		myTurtleVisible = turtleVisible;
	}

	public String getMyLanguage() {
		return myLanguage;
	}

	public void setMyLanguage(String myLanguage) {
		this.myLanguage = myLanguage;
	}

	public String getMyBackgroundColor() {
		return myBackgroundColor;
	}

	public void setMyBackgroundColor(String myBackgroundColor) {
		this.myBackgroundColor = myBackgroundColor;
	}
	
	public Map<String, Double> getCustomCommandMap() {
		return customCommandMap;
	}

	public void setCustomCommandMap(Map<String, Double> customCommandMap) {
		this.customCommandMap = customCommandMap;
	}
	
	public void setCustomCommand(String key, double value) {
		customCommandMap.put(key, value);
	}
	
	public double getCustomCommandValue(String key) {
		return customCommandMap.get(key);
	}
		
	public String getPenColor() {
		return myPenColor;
	}

	public void setPenColor(String penColor) {
		myPenColor = penColor;
	}

}

