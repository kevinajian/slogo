package model;

/**
 * Line class, contains two points
 * @author Kevin, Carlos
 */
public class Line {
	Double[] myPoint1;
	Double[] myPoint2;
	
	/**
	 * Creates a line
	 * @param x1 - double of first x coordinate
	 * @param y1 - double of first y coordinate
	 * @param x2 - double of second x coordinate
	 * @param y2 - double of second y coordinate
	 */
	public Line(double x1, double y1, double x2, double y2) {
		myPoint1 = new Double[]{x1, y1};
		myPoint2 = new Double[]{x2, y2};
	}
	
	/**
	 * calculates length of line
	 * @return - double of length
	 */
	public double calculateLength() {
		return Math.sqrt(Math.pow(myPoint2[0]-myPoint1[0],2)+Math.pow(myPoint2[1]-myPoint2[1],2));
	}
	
	public double getDegree() {
		return 0;
		// get degree
	}
}