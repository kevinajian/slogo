package controller;
import slogoGame.TurtleGame;
import view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import parser.Parser;
import model.Constants;
import model.Model;
import model.ModelController;
import model.State;

/**
 * Command string in happens here, sends this string
 * to the model to be sent to be processed.
 * Controller also receives processed info and then updates
 * the view based on this info.
 * @author carlosreyes kevinjian
 */
public class Controller { 
	private ModelController myMC;
	private View myView;
	
	/**
	 * constructor for controller
	 * @param view - view object
	 * @param parser - model object
	 */
	public Controller(View view, ModelController MC){
		myView = view;
		myMC = MC;
	}
	
	public void initiate() {
		myMC.initiate();
		double[] initialBox = new double[3];
		initialBox[0] = Constants.TURTLE_XORIGIN;
		initialBox[1] = Constants.TURTLE_YORIGIN;
		initialBox[2] = Constants.TURTLE_DEGREEORIGIN;
		myView.drawBox(initialBox);
	}
	
	/**
	 * Sends user input to the parser to be parsed and handles
	 * line drawing.
	 * @param string
	 */
	public void processInput(String string) {
		try {
			myMC.parse(string);
		} catch (Exception e) {
			e.printStackTrace();
		}
		clearGame();
		for (Model m: myMC.getModels()) {
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
			
			checkEnvironmentChanges(m);
		}
		display();
	}
	
	/**
	 * Checks to see if any environment properties are changed
	 * by user, if they are, these properties are reflected by the view.
	 * @param m
	 */
	public void checkEnvironmentChanges(Model m) {
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
	
	/**
	 * Draws a line that exists.
	 * @param line
	 */
	private void drawLine(Line line) {
		double[] currentLine = line.getLine();
		myView.drawLine(currentLine);
	}

	private void clearGame() {
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
	
	/**
	 * Get list of current lines based on all of the
	 * states up to this point.
	 * @param m
	 * @return
	 */
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
	
	/**
	 * Draws an image of the turtle.
	 * @param s
	 */
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
			myView.drawBox(boxPosition);
		}
	}
	
	public void setBackgroundColor(String c) {
		myView.getMyTurtleGame().makeBackgroundAction(c);
	}
	
	public void setPenColor(String c) {
		myView.getMyTurtleGame().makePenAction(c);
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
		for (Model m: myMC.getModels()) {
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
		Model m = myMC.getModel();
		myView.display("X position: " + m.getX());
		myView.display("Y position: " + m.getY());
		myView.display("Orientation: "+ m.getOrientation());
		for(String s : m.getVariableMap().keySet())
		{
			myView.display("Variable: " + s + " : " + m.getVariableMap().get(s));
		}
		myView.display("----------------------");
	}

	public Map<String, String> getCustomCommandMap() {
		for (Model m: myMC.getModelMap().values()) {
			return m.getCustomCommandMap();
		}
		return null;
	}
	
	public void setModelController(ModelController mc) {
		myMC = mc;
	}
	
	public ModelController getModelController() {
		return myMC;
	}
}
