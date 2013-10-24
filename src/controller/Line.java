package controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Line class that holds two coordinates
 * @author Kevin
 *
 */
public class Line {
	private double[] myCoord1 = new double[2];
	private double[] myCoord2 = new double[2];

	public void setCoord1(double x, double y){
		myCoord1[0]=x;
		myCoord1[1]=y;
	}
	
	public void setCoord2(double x, double y){
		myCoord2[0]=x;
		myCoord2[1]=y;
	}
	
	public double[] getCoord1() {
		return myCoord1;
	}
	
	public double[] getCoord2() {
		return myCoord2;
	}
	
	/**
	 * returns a double[] that holds the two coordinates' values
	 * @return - double[] of line
	 */
	public double[] getLine() {
		return new double[] {myCoord1[0], myCoord1[1], myCoord2[0], myCoord2[1]};
	}
}