package model;

/**
 * Set of x and y coordinates as well as orientation
 * @author Kevin, Carlos
 */
public class State {
	private double myX;
	private double myY;
	private double myOrientation;
	private String myPenVisible;
	private String myTurtleVisible;
	
	/**
	 * Constructor that sets x, y and orientation
	 * @param x - double of x coordinate of turtle
	 * @param y - double of y coordinate of turtle
	 * @param orientation - double of degree that the turtle is facing
	 */
	public State(double x, double y, double orientation, String turtleVisible, String penVisible) {
		myX = x;
		myY = y;
		myOrientation = orientation;
		myTurtleVisible = turtleVisible;
		myPenVisible = penVisible;
	}

	/**
	 * Gets x coordinate of state
	 * @return - double of x coordinate
	 */
	public double getX() {
		return myX;
	}
	
	/**
	 * Gets y coordinate of state
	 * @return - double of y coordinate
	 */
	public double getY() {
		return myY;
	}
	
	/**
	 * Gets orientation coordinate of state
	 * @return - double of degree
	 */
	public double getOrientation() {
		return myOrientation;
	}
	
	public String getTurtleVisible() {
		return myTurtleVisible;
	}

	public String getPenVisible() {
		return myPenVisible;
	}
}
