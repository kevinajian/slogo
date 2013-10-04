package model;

public class Line {
	Double[] myPoint1;
	Double[] myPoint2;
	public Line(double x1, double y1, double x2, double y2) {
		myPoint1 = new Double[]{x1, y1};
		myPoint2 = new Double[]{x2, y2};
	}
	
	public double calculateLength() {
		return 0;
		//pythagorean theorem
	}
	
	public double getDegree() {
		return 0;
		// get degree
	}
}
