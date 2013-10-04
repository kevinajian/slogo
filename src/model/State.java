package model;

/**
 * set of x and y coordinates as well as orientation
 * @author Kevin
 *
 */
public class State {
	private double myX;
	private double myY;
	private double myOrientation;
	
	/**
	 * constructor that sets x, y and orientation
	 * @param x - double of x coordinate of turtle
	 * @param y - double of y coordinate of turtle
	 * @param orientation - double of degree that the turtle is facing
	 */
	public State(double x, double y, double orientation) {
		myX = x;
		myY = y;
		myOrientation = orientation;
	}

	/**
	 * gets x coordinate of state
	 * @return - double of x coordinate
	 */
	public double getX() {
		return myX;
	}
	
	/**
	 * gets y coordinate of state
	 * @return - double of y coordinate
	 */
	public double getY() {
		return myY;
	}
	
	/**
	 * gets orientation coordinate of state
	 * @return - double of degree
	 */
	public double getOrientation() {
		return myOrientation;
	}

}
