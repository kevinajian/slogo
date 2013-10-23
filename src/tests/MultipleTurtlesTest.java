package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Model;
import model.State;

import org.junit.Test;

import commands.basic_syntax.Constant;
import commands.turtle_commands.Forward;

import parser.Parser;

public class MultipleTurtlesTest {

	@Test
	public void testTell() {
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

}
