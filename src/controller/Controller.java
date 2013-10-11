package controller;
import view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import parser.Constants;
import model.Model;
import model.State;

/**
 * Command string in happens here, sends this string
 * to the model to be sent to be processed.
 * Controller also receives processed info and then updates
 * the view based on this info.
 * @author carlosreyes kevinjian
 */
public class Controller { 
	private Model myModel;
	private View myView;
	
	/**
	 * constructor for controller
	 * @param view - view object
	 * @param model - model object
	 */
	public Controller(View view, Model model){
		myView = view;
		myModel=model;
	}
	
	public void processInput(String string) {
		try {
			myModel.processString(string);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//List<Line> trail = getLines();
		double[] turtlePosition = getTurtle();
/*		for (Line line:trail) {
			//view.drawLine
		}*/
		myView.drawTurtle(turtlePosition);
	}
	
/*	*//**
	 * passes user input to model to process
	 * @param input - String of user input 
	 * @throws Exception 
	 *//*
	public void processString(String string) throws Exception{
		myModel.processString(string);
		myView.
	}*/
	
	/**
	 * gets current State of turtle
	 * @return State of turtle
	 */
	public State modelCurrentState() {
		return myModel.getCurrentState();
	}
	
	/**
	 * gets turtle states
	 * @return List of Lines that create trail
	 */
	public List<State> getStates() {
		myModel.createStates();
		return myModel.getStates();
	}
	
	public List<Line> getLines() {
		List<State> states = getStates();
		List<Line> lines = new ArrayList<Line>();
		for (int i=0; i<states.size()-1; i++){
		
			Line line = new Line();
			line.setCoord1(states.get(i).getX(), states.get(i).getY()); 
			line.setCoord2(states.get(i+1).getX(), states.get(i+1).getY());
			lines.add(line);
		}
		return lines;
	}
	
	public double[] getTurtle() {
		if (myModel.getCurrentState().getTurtleVisible().equals(Constants.TURTLE_NOTSHOWING)) return null;
		else {
			double[] coordinates = {myModel.getX(), myModel.getY(), myModel.getOrientation()};
			return coordinates;
		}
	}
	
	public Map getVariables() {
		return myModel.getVariableMap();
	}
	
}
