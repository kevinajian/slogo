package controller;

import java.util.ArrayList;
import java.util.List;

public class Line {
	private List<Double> myCoord1;
	private List<Double> myCoord2;

	public void setCoord1(double x, double y){
		myCoord1.add(x);
		myCoord1.add(y);
	}
	
	public void setCoord2(double x, double y){
		myCoord2.add(x);
		myCoord2.add(y);
	}
	
	public List<Double> getCoord1() {
		return myCoord1;
	}
	
	public List<Double> getCoord2() {
		return myCoord2;
	}
	
	public List<Double> getLine() {
		List<Double> line = new ArrayList<Double>();
		line.add(myCoord1.get(0)); line.add(myCoord1.get(1));
		line.add(myCoord2.get(0)); line.add(myCoord2.get(1));
		return line;
	}
}
