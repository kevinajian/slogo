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
		double[] initialBox = new double[3];
		initialBox[0] = Constants.TURTLE_XORIGIN;
		initialBox[1] = Constants.TURTLE_YORIGIN;
		initialBox[2] = Constants.TURTLE_DEGREEORIGIN;
		myView.drawBox(initialBox);
	}
	
	public void processInput(String string) {
		try {
			myParser.parse(string);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clearLinesAndTurtlesAndBoxes();
		for (Model m: myParser.getModels().values()) {
			List<Line> trail = getLines(m);

			for (Line line:trail) {
				drawLine(line);
			}
			
			State currentState = m.getCurrentState();
			drawTurtle(currentState);
			for (State s:m.getStamps()) {
				System.out.println("drawing stamp");
				drawTurtle(s);
			}
			drawBox(m);
			
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
		display();
	}

	private void drawLine(Line line) {
		double[] currentLine = line.getLine();
		myView.drawLine(currentLine);
	}

	private void clearLinesAndTurtlesAndBoxes() {
		clearLines();
		clearTurtles();
		clearBoxes();
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
	
	public void drawTurtle(State s) {
		double[] turtlePosition = getTurtle(s);
		if (turtlePosition != null) {
			myView.drawTurtle(turtlePosition);
		}
	}
	
	public double[] getTurtle(State s) {
		if (s.getTurtleVisible().equals(Constants.TURTLE_NOTSHOWING)) return null;
		else {
			double[] coordinates = {s.getX(), s.getY(), s.getOrientation()};
			return coordinates;
		}
	}
	
	public double[] getBox(Model m) {
		String turtleVisible = m.getCurrentState().getTurtleVisible();
		double[] ret;
		if (turtleVisible.equals(Constants.TURTLE_NOTSHOWING)) { 
			m.getCurrentState().setTurtleVisible(Constants.TURTLE_SHOWING);
		}
		if (m.getActive()) {
			ret = getTurtle(m.getCurrentState());
			m.getCurrentState().setTurtleVisible(turtleVisible);
			return getTurtle(m.getCurrentState());
		}
		m.getCurrentState().setTurtleVisible(turtleVisible);
		return null;
	}
	
	public void drawBox(Model m) {
		double[] boxPosition = getBox(m);
		if (boxPosition != null) {
			System.out.println("drawing box");
			myView.drawBox(boxPosition);
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
	
	public void clearTurtles() {
		myView.clearTurtles();
	}
	
	private void clearBoxes() {
		myView.clearBoxes();
	}

	public void display() {
		Model m = myParser.getModel();
		System.out.println("WE REALLY OUT HERE" + m.getVariableMap().keySet().size());
		for(String s : m.getVariableMap().keySet())
		{
			System.out.println(s + " : " + m.getVariableMap().get(s));
			myView.display(s + " : " + m.getVariableMap().get(s));
		}
	}
}
