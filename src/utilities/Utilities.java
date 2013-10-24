package utilities;

/**
 * Contains methods that can be used by all commands
 * @author carlos
 *
 */
public class Utilities {

	/**
	 * Uses the pythagorean theorem to calculate the distance that the turtle moved
	 * by finding the length of the hypotenuse of the triangle formed by the two sets
	 * of coordinates.
	 */
	public static final double calculateLength(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)); 
	}
}
