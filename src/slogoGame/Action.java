package slogoGame;
import slogoGame.Line;
import java.util.*;

public class Action implements Constants{
	private Collection<Line> myLines = new ArrayList<Line>();
	private double[] firstTurtlePosition;
	private double[] lastTurtlePosition;
	private Turtle myTurtle;

	public Action(double[] originalTurtlePosition, Turtle turtle) {
		firstTurtlePosition = originalTurtlePosition;
		myTurtle = turtle;
	}
	
	public void addLine (Line line){
		myLines.add(line);
	}
	
	public void addFirstTurtle(double[] turtlePosition){
		firstTurtlePosition = turtlePosition;
	}
	
	public void addLastTurtle (double[] turtlePosition){
		lastTurtlePosition = turtlePosition;
	}
	
	public double[] getLastTurtle (){
		return lastTurtlePosition;
	}
	
	public void undo(){
		for (Line line : myLines){
			line.suspend();
		}
		myTurtle.setPos(firstTurtlePosition[0], firstTurtlePosition[1]);
		myTurtle.rotate(firstTurtlePosition[2]);
	}
	
	public void redo(){
		for (Line line : myLines){
			line.resume();
		}
		myTurtle.setPos(lastTurtlePosition[0], lastTurtlePosition[1]);
		myTurtle.rotate(lastTurtlePosition[2]);
	}
	
	public void remove(){
		for (Line line : myLines){
			line.remove();
		}
	}

}
