package model;

import java.util.ArrayList;
import java.util.List;

import parser.Constants;
import parser.Parser;

/**
 * interprets user input and contains state
 * @author Kevin, Carlos
 */
public class Model {
	
	private List<State> myStates = new ArrayList<State>();
	private State myOrigin;
	private String myTurtleVisible = Constants.TURTLE_SHOWING;
	private String myPenVisible = Constants.PEN_SHOWING;

	/**
	 * initializes the model
	 */
	public void initiate(){
		myOrigin = new State(Constants.TURTLE_XORIGIN,Constants.TURTLE_YORIGIN,Constants.TURTLE_DEGREEORIGIN, Constants.TURTLE_SHOWING, Constants.PEN_SHOWING);
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

	/**
	 * get current state of the turtle
	 * @return - State of turtle
	 */
	public State getCurrentState() {
		return myStates.get(myStates.size()-1);
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

}
