package tests;

import static org.junit.Assert.*;
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
import commands.basic_syntax.Constant;

public class MovementTest {
	
	@Test
	public void testForward() {
		Model model = new Model(1);
		model.addState(new State(0.0, 0.0, 0.0, "1", "1", "Black"));
		Forward forward = new Forward();
		Constant left = new Constant();
		left.setInputValueOne(1.0);
		forward.setLeftChild(left);
		assertEquals(forward.evaluate(model), 1.0, 0.0);
		
		State state = new State(0.0, 1.0, 0.0, "1", "1", "Black");
		State modelState = model.getCurrentState();
		assertEquals(state.getX(), modelState.getX(), 0.0);
		assertEquals(state.getY(), modelState.getY(), 0.0);
		assertEquals(state.getOrientation(), modelState.getOrientation(), 0.0);
		assertEquals(state.getTurtleVisible(), modelState.getTurtleVisible());
		assertEquals(state.getPenVisible(), modelState.getPenVisible());
	}

	@Test
	public void testBack() {
		Model model = new Model(1);
		model.addState(new State(0.0, 0.0, 0.0, "1", "1", "Black"));
		Back back = new Back();
		Constant left = new Constant();
		left.setInputValueOne(5.0);
		back.setLeftChild(left);
		assertEquals(back.evaluate(model), 5.0, 0.0);
		
		State state = new State(0.0, -5.0, 0.0, "1", "1", "Black");
		State modelState = model.getCurrentState();
		assertEquals(state.getX(), modelState.getX(), 0.0);
		assertEquals(state.getY(), modelState.getY(), 0.0);
		assertEquals(state.getOrientation(), modelState.getOrientation(), 0.0);
		assertEquals(state.getTurtleVisible(), modelState.getTurtleVisible());
		assertEquals(state.getPenVisible(), modelState.getPenVisible());
	}
	
	@Test
	public void testLeft() {
		Model model = new Model(1);
		model.addState(new State(0.0, 0.0, 0.0, "1", "1", "Black"));
		Left left = new Left();
		Constant leftChild = new Constant();
		leftChild.setInputValueOne(90.0);
		left.setLeftChild(leftChild);
		assertEquals(left.evaluate(model), 90.0, 0.0);

		State state = new State(0.0, 0.0, 270.0, "1", "1", "Black");
		State modelState = model.getCurrentState();
		assertEquals(state.getX(), modelState.getX(), 0.0);
		assertEquals(state.getY(), modelState.getY(), 0.0);
		assertEquals(state.getOrientation(), modelState.getOrientation(), 0.0);
		assertEquals(state.getTurtleVisible(), modelState.getTurtleVisible());
		assertEquals(state.getPenVisible(), modelState.getPenVisible());
	}
	
	@Test
	public void testRight() {
		Model model = new Model(1);
		model.addState(new State(0.0, 0.0, 0.0, "1", "1", "Black"));
		Right right = new Right();
		Constant left = new Constant();
		left.setInputValueOne(40.0);
		right.setLeftChild(left);
		assertEquals(right.evaluate(model), 40.0, 0.0);
		
		State state = new State(0.0, 0.0, 40.0, "1", "1", "Black");
		State modelState = model.getCurrentState();
		assertEquals(state.getX(), modelState.getX(), 0.0);
		assertEquals(state.getY(), modelState.getY(), 0.0);
		assertEquals(state.getOrientation(), modelState.getOrientation(), 0.0);
		assertEquals(state.getTurtleVisible(), modelState.getTurtleVisible());
		assertEquals(state.getPenVisible(), modelState.getPenVisible());
	}
	
	@Test
	public void testHome() {
		Model model = new Model(1);
		model.addState(new State(0.0, 0.0, 0.0, "1", "1", "Black"));
		Forward forward = new Forward();
		Constant left = new Constant();
		left.setInputValueOne(5.0);
		forward.setLeftChild(left);
		forward.evaluate(model);
		State modelState = model.getCurrentState();
		Home home = new Home();
		assertEquals(home.evaluate(model), 5.0, 0.0);

		State state = new State(0.0, 0.0, 0.0, "1", "1", "Black");
		modelState = model.getCurrentState();
		assertEquals(state.getX(), modelState.getX(), 0.0);
		assertEquals(state.getY(), modelState.getY(), 0.0);
		assertEquals(state.getOrientation(), modelState.getOrientation(), 0.0);
		assertEquals(state.getTurtleVisible(), modelState.getTurtleVisible());
		assertEquals(state.getPenVisible(), modelState.getPenVisible());
	}
	
	@Test
	public void testSetXY() {
		Model model = new Model(1);
		model.addState(new State(0.0, 0.0, 0.0, "1", "1", "Black"));
		SetXY setXY = new SetXY();
		Constant left = new Constant();
		left.setInputValueOne(3.0);
		setXY.setLeftChild(left);
		Constant right = new Constant();
		right.setInputValueOne(4.0);
		setXY.setRightChild(right);
		assertEquals(setXY.evaluate(model), 5.0, 0.0);
		
		State state = new State(3.0, 4.0, 0.0, "1", "1", "Black");
		State modelState = model.getCurrentState();
		assertEquals(state.getX(), modelState.getX(), 0.0);
		assertEquals(state.getY(), modelState.getY(), 0.0);
		assertEquals(state.getOrientation(), modelState.getOrientation(), 0.0);
		assertEquals(state.getTurtleVisible(), modelState.getTurtleVisible());
		assertEquals(state.getPenVisible(), modelState.getPenVisible());
	}
	
	@Test
	public void testSetHeading() {
		Model model = new Model(1);
		model.addState(new State(0.0, 0.0, 0.0, "1", "1", "Black"));
		SetHeading setHeading = new SetHeading();
		Constant left = new Constant();
		left.setInputValueOne(380.0);
		setHeading.setLeftChild(left);
		assertEquals(setHeading.evaluate(model), 20.0, 0.0);
		
		State state = new State(0.0, 0.0, 20.0, "1", "1", "Black");
		State modelState = model.getCurrentState();
		assertEquals(state.getX(), modelState.getX(), 0.0);
		assertEquals(state.getY(), modelState.getY(), 0.0);
		assertEquals(state.getOrientation(), modelState.getOrientation(), 0.0);
		assertEquals(state.getTurtleVisible(), modelState.getTurtleVisible());
		assertEquals(state.getPenVisible(), modelState.getPenVisible());
	}
	
	@Test
	public void testTowards() {
		Model model = new Model(1);
		model.addState(new State(0.0, 0.0, 0.0, "1", "1", "Black"));
		Towards towards = new Towards();
		Constant left = new Constant();
		left.setInputValueOne(-1.0);
		towards.setLeftChild(left);
		Constant right = new Constant();
		right.setInputValueOne(-1.0);
		towards.setRightChild(right);
		
		assertEquals(towards.evaluate(model), 225.0, 0.0);

		left.setInputValueOne(0.0);
		right.setInputValueOne(1.0);
		assertEquals(towards.evaluate(model), 225, 0.0);

		left.setInputValueOne(-1.0);
		right.setInputValueOne(1.0);
		assertEquals(towards.evaluate(model), 315.0, 0.0);

		left.setInputValueOne(0.0);
		right.setInputValueOne(0.0);
		assertEquals(towards.evaluate(model), 315.0, 0.0);

		left.setInputValueOne(1.0);
		right.setInputValueOne(-1.0);
		assertEquals(towards.evaluate(model), 135.0, 0.0);
		
		left.setInputValueOne(0.0);
		right.setInputValueOne(0.0);
		assertEquals(towards.evaluate(model), 135.0, 0.0);

		left.setInputValueOne(1.0);
		right.setInputValueOne(1.0);
		assertEquals(towards.evaluate(model), 45.0, 0.0);
	}
}
