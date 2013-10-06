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
		model.addState(new State(0.0, 0.0, 0.0));
		Forward forward = new Forward();
		forward.setInputList(new ArrayList<Double>(){{add(1.0);}});
		assertEquals(forward.operation(model), 1.0, 0.0);
	}

	@Test
	public void testBack() {
		Model model = new Model();
		model.addState(new State(0.0, 0.0, 0.0));
		Back back = new Back();
		back.setInputList(new ArrayList<Double>(){{add(5.0);}});
		assertEquals(back.operation(model), 5.0, 0.0);
	}
	
	@Test
	public void testLeft() {
		Model model = new Model();
		model.addState(new State(0.0, 0.0, 0.0));
		Left left = new Left();
		left.setInputList(new ArrayList<Double>(){{add(5.0);}});
		assertEquals(left.operation(model), 5.0, 0.0);
	}
	
	@Test
	public void testRight() {
		Model model = new Model();
		model.addState(new State(0.0, 0.0, 0.0));
		Right right = new Right();
		right.setInputList(new ArrayList<Double>(){{add(5.0);}});
		assertEquals(right.operation(model), 5.0, 0.0);
	}
}
