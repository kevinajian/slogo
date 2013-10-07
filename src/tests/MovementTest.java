package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import model.Model;
import model.State;

import org.junit.Test;

import commands.turtle_commands.Back;
import commands.turtle_commands.Forward;
import commands.turtle_commands.Left;
import commands.turtle_commands.Right;

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
		assertEquals(state.getTurtleVisible(), modelState.getTurtleVisible(), 0.0);
		assertEquals(state.getPenVisible(), modelState.getPenVisible(), 0.0);
	}

	@Test
	public void testBack() {
		Model model = new Model();
		model.addState(new State(0.0, 0.0, 0.0, "1", "1"));
		Back back = new Back();
		back.setInputList(new ArrayList<Double>(){{add(5.0);}});
		assertEquals(back.evaluate(model), 5.0, 0.0);
	}
	
	@Test
	public void testLeft() {
		Model model = new Model();
		model.addState(new State(0.0, 0.0, 0.0, "1", "1"));
		Left left = new Left();
		left.setInputList(new ArrayList<Double>(){{add(5.0);}});
		assertEquals(left.evaluate(model), 5.0, 0.0);
	}
	
	@Test
	public void testRight() {
		Model model = new Model();
		model.addState(new State(0.0, 0.0, 0.0, "1", "1"));
		Right right = new Right();
		right.setInputList(new ArrayList<Double>(){{add(5.0);}});
		assertEquals(right.evaluate(model), 5.0, 0.0);
	}
}
