package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import model.Model;
import model.State;

import org.junit.Test;

import commands.turtle_commands.Back;
import commands.turtle_commands.Forward;
import commands.turtle_commands.Home;
import commands.turtle_commands.Left;
import commands.turtle_commands.Right;
import commands.turtle_commands.SetHeading;
import commands.turtle_commands.SetXY;
import commands.turtle_commands.Towards;

public class MovementTest {
	
	@Test
	public void testForward() {
		Model model = new Model();
		model.addState(new State(0.0, 0.0, 0.0, "1", "1"));
		Forward forward = new Forward();
		forward.setInputList(new ArrayList<Double>(){{add(1.0);}});
		assertEquals(forward.evaluate(model), 1.0, 0.0);
		
		State state = new State(0.0, 1.0, 0.0, "1", "1");
		State modelState = model.getCurrentState();
		assertEquals(state.getX(), modelState.getX(), 0.0);
		assertEquals(state.getY(), modelState.getY(), 0.0);
		assertEquals(state.getOrientation(), modelState.getOrientation(), 0.0);
		assertEquals(state.getTurtleVisible(), modelState.getTurtleVisible());
		assertEquals(state.getPenVisible(), modelState.getPenVisible());
	}

	@Test
	public void testBack() {
		Model model = new Model();
		model.addState(new State(0.0, 0.0, 0.0, "1", "1"));
		Back back = new Back();
		back.setInputList(new ArrayList<Double>(){{add(5.0);}});
		assertEquals(back.evaluate(model), 5.0, 0.0);
		
		State state = new State(0.0, -5.0, 0.0, "1", "1");
		State modelState = model.getCurrentState();
		assertEquals(state.getX(), modelState.getX(), 0.0);
		assertEquals(state.getY(), modelState.getY(), 0.0);
		assertEquals(state.getOrientation(), modelState.getOrientation(), 0.0);
		assertEquals(state.getTurtleVisible(), modelState.getTurtleVisible());
		assertEquals(state.getPenVisible(), modelState.getPenVisible());
	}
	
	@Test
	public void testLeft() {
		Model model = new Model();
		model.addState(new State(0.0, 0.0, 0.0, "1", "1"));
		Left left = new Left();
		left.setInputList(new ArrayList<Double>(){{add(90.0);}});
		assertEquals(left.evaluate(model), 90.0, 0.0);

		State state = new State(0.0, 0.0, 270.0, "1", "1");
		State modelState = model.getCurrentState();
		assertEquals(state.getX(), modelState.getX(), 0.0);
		assertEquals(state.getY(), modelState.getY(), 0.0);
		assertEquals(state.getOrientation(), modelState.getOrientation(), 0.0);
		assertEquals(state.getTurtleVisible(), modelState.getTurtleVisible());
		assertEquals(state.getPenVisible(), modelState.getPenVisible());
	}
	
	@Test
	public void testRight() {
		Model model = new Model();
		model.addState(new State(0.0, 0.0, 0.0, "1", "1"));
		Right right = new Right();
		right.setInputList(new ArrayList<Double>(){{add(40.0);}});
		assertEquals(right.evaluate(model), 40.0, 0.0);
		
		State state = new State(0.0, 0.0, 40.0, "1", "1");
		State modelState = model.getCurrentState();
		assertEquals(state.getX(), modelState.getX(), 0.0);
		assertEquals(state.getY(), modelState.getY(), 0.0);
		assertEquals(state.getOrientation(), modelState.getOrientation(), 0.0);
		assertEquals(state.getTurtleVisible(), modelState.getTurtleVisible());
		assertEquals(state.getPenVisible(), modelState.getPenVisible());
	}
	
	@Test
	public void testHome() {
		Model model = new Model();
		model.addState(new State(0.0, 0.0, 0.0, "1", "1"));
		Forward forward = new Forward();
		forward.setInputList(new ArrayList<Double>(){{add(5.0);}});
		forward.evaluate(model);
		State modelState = model.getCurrentState();
		Home home = new Home();
		assertEquals(home.evaluate(model), 5.0, 0.0);

		State state = new State(0.0, 0.0, 0.0, "1", "1");
		modelState = model.getCurrentState();
		assertEquals(state.getX(), modelState.getX(), 0.0);
		assertEquals(state.getY(), modelState.getY(), 0.0);
		assertEquals(state.getOrientation(), modelState.getOrientation(), 0.0);
		assertEquals(state.getTurtleVisible(), modelState.getTurtleVisible());
		assertEquals(state.getPenVisible(), modelState.getPenVisible());
	}
	
	@Test
	public void testSetXY() {
		Model model = new Model();
		model.addState(new State(0.0, 0.0, 0.0, "1", "1"));
		SetXY setXY = new SetXY();
		setXY.setInputList(new ArrayList<Double>(){{add(3.0); add(4.0);}});
		assertEquals(setXY.evaluate(model), 5.0, 0.0);
		
		State state = new State(3.0, 4.0, 0.0, "1", "1");
		State modelState = model.getCurrentState();
		assertEquals(state.getX(), modelState.getX(), 0.0);
		assertEquals(state.getY(), modelState.getY(), 0.0);
		assertEquals(state.getOrientation(), modelState.getOrientation(), 0.0);
		assertEquals(state.getTurtleVisible(), modelState.getTurtleVisible());
		assertEquals(state.getPenVisible(), modelState.getPenVisible());
	}
	
	@Test
	public void testSetHeading() {
		Model model = new Model();
		model.addState(new State(0.0, 0.0, 0.0, "1", "1"));
		SetHeading setHeading = new SetHeading();
		setHeading.setInputList(new ArrayList<Double>(){{add(380.0);}});
		assertEquals(setHeading.evaluate(model), 20.0, 0.0);
		
		State state = new State(0.0, 0.0, 20.0, "1", "1");
		State modelState = model.getCurrentState();
		assertEquals(state.getX(), modelState.getX(), 0.0);
		assertEquals(state.getY(), modelState.getY(), 0.0);
		assertEquals(state.getOrientation(), modelState.getOrientation(), 0.0);
		assertEquals(state.getTurtleVisible(), modelState.getTurtleVisible());
		assertEquals(state.getPenVisible(), modelState.getPenVisible());
	}
	
//	@Test
//	public void testTowards() {
//		Model model = new Model();
//		model.addState(new State(0.0, 0.0, 0.0, "1", "1"));
//		Towards towards = new Towards();
//		towards.setInputList(new ArrayList<Double>(){{add(-1.0); add(-1.0);}});
//		System.out.println(towards.evaluate(model));
//		System.out.println(45.0);
//		assertEquals(towards.evaluate(model), 45.0, 5.2);
//
//		
//		State state = new State(0.0, 0.0, 90.0, "1", "1");
//		State modelState = model.getCurrentState();
//		
//		System.out.println(modelState.getX());
//		System.out.println(modelState.getY());
//		System.out.println(modelState.getOrientation());
//		System.out.println(modelState.getTurtleVisible());
//		System.out.println(modelState.getPenVisible());
//		
//		assertEquals(state.getX(), modelState.getX(), 0.0);
//		assertEquals(state.getY(), modelState.getY(), 0.0);
//		assertEquals(state.getOrientation(), modelState.getOrientation(), 0.0);
//		assertEquals(state.getTurtleVisible(), modelState.getTurtleVisible());
//		assertEquals(state.getPenVisible(), modelState.getPenVisible());
//	}
}
