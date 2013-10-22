package controller;
import slogoGame.TurtleGame;
import view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import parser.Parser;
import model.Constants;
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

	private Parser myParser;
	private View myView;
	
	/**
	 * constructor for controller
	 * @param view - view object
	 * @param parser - model object
	 */
	public Controller(View view, Parser parser){
		myView = view;
		myParser = parser;
	}
	
	public void initiate() {
		myParser.initiate();
	}
	
	public void processInput(String string) {
		try {
			myParser.parse(string);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clearLines();
		for (Model m: myParser.getModels().values()) {
			List<Line> trail = getLines(m);		

			for (Line line:trail) {
				double[] currentLine = line.getLine();
				myView.drawLine(currentLine);
			}
			double[] turtlePosition = getTurtle(m);
			myView.drawTurtle(turtlePosition);
			
			if(m.isBackgroundChanged()){
				m.setBackgroundChanged(false);
				setBackgroundColor(m.getBackgroundColor());
			}
			if(m.isPenColorChanged()){
				m.setPenColorChanged(false);
				setPenColor(m.getPenColor());
			}
			if(m.isPenSizeChanged()) {
				m.setPenSizeChanged(false);
				setPenSize(m.getPenSize());
			}
			if(m.isStamp()) {
				m.setStamp(false);
			}
			if(m.isShapeChanged()) {
				m.setShapeChanged(false);
				setShape(m.getShape());
			}

		}
	}

	/**
	 * gets current State of turtle
	 * @return State of turtle
	 */
	public State modelCurrentState(Model m) {
		return m.getCurrentState();
	}
	
	/**
	 * gets turtle states
	 * @return List of Lines that create trail
	 */
	public List<State> getStates(Model m) {
		m.createStates();
		return m.getStates();
	}
	
	public List<Line> getLines(Model m) {
		List<State> states = getStates(m);
		List<Line> lines = new ArrayList<Line>();
		for (int i=0; i<states.size()-1; i++){
			if (states.size()<2) {
				return lines;
			}
			if(states.get(i+1).getPenVisible().equals(Constants.PEN_SHOWING)){
				Line line = new Line();
				line.setCoord1(states.get(i).getX(), states.get(i).getY()); 
				line.setCoord2(states.get(i+1).getX(), states.get(i+1).getY());
				lines.add(line);
			}
		}
		return lines;
	}
	
	public double[] getTurtle(Model m) {
		if (m.getCurrentState().getTurtleVisible().equals(Constants.TURTLE_NOTSHOWING)) return null;
		else {
			double[] coordinates = {m.getX(), m.getY(), m.getOrientation()};
			return coordinates;
		}
	}
	
	public Parser getParser() {
		return myParser;
	}
	
	public void setParser(Parser p) {
		myParser = p;
	}
	
	public void setBackgroundColor(String c) {
		myView.getMyTurtleGame().setBackground(c);
	}
	
	public void setPenColor(String c) {
		myView.getMyTurtleGame().setPenColor(c);
	}
	
	private void setPenSize(double d) {
		myView.getMyTurtleGame().setPenSize(d);
	}
	
	private void setShape(String shape) {
		myView.getMyTurtleGame().setTurtleImage(shape);
	}

	public List getCommandList(Model m)
	{
		return m.getCommands();
	}
	
	public void resetModels() {
		for (Model m: myParser.getModels().values()) {
			m.resetModel();
		}
	}
	
	public void clearLines() {
		myView.clearLines();
	}
	
	public void display(String input) {
		myView.display(input);
	}
	
	public void setMouseX() {
		for(Model m : myParser.getModels().values())
			m.setMouseX(myView.getMouseX());
	}
	
	public void setMouseY() {
		for(Model m : myParser.getModels().values()){
			m.setMouseY(myView.getMouseY());
		}
	}
	
	public void setClicked() {
		for(Model m : myParser.getModels().values()){
			m.setClicked(myView.getClicked());
		}
	}
	
	
}
