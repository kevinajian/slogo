package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import multiple_turtles.Tell;
import commands.Command;
import parser.Parser;

/**
 * interprets user input and contains state
 * @author Kevin, Carlos
 */
public class Model implements TurtleCommands, TurtleQueries, MathModel {
	
	private int myId;
	private List<State> myStates = new ArrayList<State>();
	private State myOrigin;
	private String myTurtleVisible = Constants.TURTLE_SHOWING;
	private String myPenVisible = Constants.PEN_SHOWING;
	private List<Command> myCommands = new ArrayList<Command>();
	private Map<String, Double> myCustomCommandMap = new HashMap<String, Double>();
	private String myBackgroundColor = Constants.DEFAULT_BACKGROUND_COLOR;
	private String myPenColor = Constants.DEFAULT_PEN_COLOR;
	private double myPenSize = Constants.DEFAULT_PEN_SIZE;
	private String myShape;
	private boolean myBackgroundChanged = false;
	private boolean myPenColorChanged = false;
	private boolean myPenSizeChanged = false;
	private boolean myStamp = false;
	private boolean shapeChanged = false;
	private int myMouseX;
	private int myMouseY;
	private boolean myShapeChanged = false;
	private boolean myActive = true;

	public Model(int id) {
		myId = id;
	}
	
	public int getId() {
		return myId;
	}
	
	public void setId(int id) {
		myId = id;
	}
	
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
		for (Command c:myCommands){
			if (c instanceof Tell || myActive) {
				c.evaluate(this);
			}
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

	public String getBackgroundColor() {
		return myBackgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		myBackgroundColor = backgroundColor;
	}
		
	public String getPenColor() {
		return myPenColor;
	}

	public void setPenColor(String penColor) {
		myPenColor = penColor;
	}
	
	public boolean isBackgroundChanged() {
		return myBackgroundChanged;
	}

	public void setBackgroundChanged(boolean backgroundChanged) {
		myBackgroundChanged = backgroundChanged;
	}
	
	public boolean isPenColorChanged() {
		return myPenColorChanged;
	}

	public void setPenColorChanged(boolean penChanged) {
		myPenColorChanged = penChanged;
	}

	public double getPenSize() {
		return myPenSize;
	}

	public void setPenSize(double d) {
		myPenSize = d;
	}
	
	public boolean isPenSizeChanged() {
		return myPenSizeChanged;
	}

	public void setPenSizeChanged(boolean penSizeChanged) {
		myPenSizeChanged = penSizeChanged;
	}
	
	public boolean isStamp() {
		return myStamp;
	}

	public void setStamp(boolean stamp) {
		myStamp = stamp;
	}

	public String getShape() {
		return myShape;
	}

	public void setShape(String shape) {
		myShape = shape;
	}
	
	public boolean isShapeChanged() {
		return myShapeChanged;
	}

	public void setShapeChanged(boolean shapeChanged) {
		myShapeChanged = shapeChanged;
	}
	
	public Map<String, Double> getCustomCommandMap() {
		return myCustomCommandMap;
	}

	public void setCustomCommandMap(Map<String, Double> customCommandMap) {
		myCustomCommandMap = customCommandMap;
	}
	
	public void setCustomCommand(String key, double value) {
		myCustomCommandMap.put(key, value);
	}
	
	public double getCustomCommandValue(String key) {
		return myCustomCommandMap.get(key);
	}

	public boolean getActive() {
		return myActive;
	}

	public void setActive(boolean active) {
		myActive = active;
	}

	public int getMouseX() {
		return myMouseX;
	}

	public void setMouseX(int myMouseX) {
		this.myMouseX = myMouseX;
	}

	public int getMouseY() {
		return myMouseY;
	}

	public void setMouseY(int myMouseY) {
		this.myMouseY = myMouseY;
	}

}

