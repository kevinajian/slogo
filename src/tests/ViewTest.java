package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import model.Model;
import model.State;

import org.junit.Test;

import parser.Constants;
import commands.basic_syntax.Constant;
import commands.turtle_commands.Forward;
import commands.view.ClearScreen;
import commands.view.HideTurtle;
import commands.view.SetPenDown;
import commands.view.SetPenUp;
import commands.view.ShowTurtle;

public class ViewTest {

	@Test
	public void testClearScreen() {
		Model model = new Model();
		model.addState(new State(0.0, 0.0, 0.0, "1", "1"));
		Forward forward = new Forward();
		Constant left = new Constant();
		left.setInputValueOne(5.0);
		forward.setLeftChild(left);
		forward.evaluate(model);
		ClearScreen clearScreen = new ClearScreen();
		assertEquals(clearScreen.evaluate(model), 5.0, 0.0);
		
		State state = new State(0.0, 0.0, 0.0, "1", "1");
		State modelState = model.getCurrentState();
		assertEquals(state.getX(), modelState.getX(), 0.0);
		assertEquals(state.getY(), modelState.getY(), 0.0);
		assertEquals(state.getOrientation(), modelState.getOrientation(), 0.0);
		assertEquals(state.getTurtleVisible(), modelState.getTurtleVisible());
		assertEquals(state.getPenVisible(), modelState.getPenVisible());
	}

	@Test
	public void testHideTurtle() {
		Model model = new Model();
		assertEquals(model.getTurtleVisible(), Constants.TURTLE_SHOWING);
		
		HideTurtle hideTurtle = new HideTurtle();
		assertEquals(hideTurtle.evaluate(model), Double.parseDouble(Constants.TURTLE_NOTSHOWING), 0.0);
		assertEquals(model.getTurtleVisible(), Constants.TURTLE_NOTSHOWING);
	}
	
	@Test
	public void testShowTurtle() {
		Model model = new Model();
		assertEquals(model.getTurtleVisible(), Constants.TURTLE_SHOWING);
		
		HideTurtle hideTurtle = new HideTurtle();
		assertEquals(hideTurtle.evaluate(model), Double.parseDouble(Constants.TURTLE_NOTSHOWING), 0.0);
		
		ShowTurtle showTurtle = new ShowTurtle();
		assertEquals(showTurtle.evaluate(model), Double.parseDouble(Constants.TURTLE_SHOWING), 0.0);
		assertEquals(model.getTurtleVisible(), Constants.TURTLE_SHOWING);
	}
	
	@Test
	public void testSetPenUp() {
		Model model = new Model();
		SetPenUp penUp = new SetPenUp();
		assertEquals(penUp.evaluate(model), Double.parseDouble(Constants.PEN_NOTSHOWING), 0.0);
		assertEquals(model.getPenVisible(), Constants.PEN_NOTSHOWING);
	}
	
	@Test
	public void testSetPenDown() {
		Model model = new Model();
		SetPenUp penUp = new SetPenUp();
		assertEquals(penUp.evaluate(model), Double.parseDouble(Constants.PEN_NOTSHOWING), 0.0);
		assertEquals(model.getPenVisible(), Constants.PEN_NOTSHOWING);
		
		SetPenDown penDown = new SetPenDown();
		assertEquals(penDown.evaluate(model), Double.parseDouble(Constants.PEN_SHOWING), 0.0);
		assertEquals(model.getPenVisible(), Constants.PEN_SHOWING);
	}
}
