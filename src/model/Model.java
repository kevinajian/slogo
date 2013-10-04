package model;

import java.util.ArrayList;
import java.util.List;

/**
 * interprets user input and contains state
 * @author Kevin
 */
public class Model {
	
	private List<State> myStates = new ArrayList<State>();
	private List<Line> myTrail = new ArrayList<Line>();
	private State myOrigin;
	
	/**
	 * initializes the model
	 */
	public void initiate(){
		myOrigin = new State(0,0,0);
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
	
	
	public void addState(State state) {
		myStates.add(state);	
	}

	/**
	 * gets trail that the turtle has traveled
	 * @return - List of Lines that make trail
	 */
	public List<Line> getTrail() {
		return myTrail;
	}

	/**
	 * get current state of the turtle
	 * @return - State of turtle
	 */
	public State getCurrentState() {
		return myStates.get(myStates.size()-1);
	}

	public void processString(String input) {
		
	}

}
