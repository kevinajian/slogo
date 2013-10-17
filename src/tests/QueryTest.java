package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import model.Constants;
import model.Model;
import model.State;

import org.junit.Test;

import commands.basic_syntax.Constant;
import commands.turtle_commands.Forward;
import commands.turtle_commands.Left;
import commands.turtle_queries.Heading;
import commands.turtle_queries.PenDown;
import commands.turtle_queries.Showing;
import commands.turtle_queries.XCor;
import commands.turtle_queries.YCor;
import commands.view.ClearScreen;
import commands.view.HideTurtle;
import commands.view.SetPenDown;
import commands.view.SetPenUp;
import commands.view.ShowTurtle;

public class QueryTest {

	@Test
	public void testHeading() {
		Model model = new Model();
		model.addState(new State(0.0, 0.0, 0.0, "1", "1"));
		Left left = new Left();
		Constant leftChild = new Constant();
		leftChild.setInputValueOne(90.0);
		left.setLeftChild(leftChild);
		left.evaluate(model);
		Heading heading = new Heading();
		assertEquals(heading.evaluate(model), 270.0, 0.0);
	}
	
	@Test
	public void testPenDown() {
		Model model = new Model();		
		PenDown penDown = new PenDown();
		Constant left = new Constant();
		left.setInputValueOne(30.0);
		penDown.setLeftChild(left);
		assertEquals(penDown.evaluate(model), 1, 0.0);
		
		SetPenUp setPenUp = new SetPenUp();
		setPenUp.evaluate(model);
		assertEquals(penDown.evaluate(model), 0, 0.0);
		
		SetPenDown setPenDown = new SetPenDown();
		setPenDown.evaluate(model);
		assertEquals(penDown.evaluate(model), 1, 0.0);
	}

	@Test
	public void testShowing() {
		Model model = new Model();
		Showing showing = new Showing();
		assertEquals(showing.evaluate(model), 1, 0.0);
		
		HideTurtle hideTurtle = new HideTurtle();
		hideTurtle.evaluate(model);
		assertEquals(showing.evaluate(model), 0, 0.0);
		
		ShowTurtle showTurtle = new ShowTurtle();
		showTurtle.evaluate(model);
		assertEquals(showing.evaluate(model), 1, 0.0);
	}
	
	@Test
	public void testXCor() {
		Model model = new Model();
		model.addState(new State(0.0, 0.0, 0.0, "1", "1"));
		Forward forward = new Forward();
		Constant left = new Constant();
		left.setInputValueOne(1.0);
		forward.setLeftChild(left);
		forward.evaluate(model);
		XCor xCor = new XCor();
		assertEquals(xCor.evaluate(model), 0.0, 0.0);
	}

	@Test
	public void testYCor() {
		Model model = new Model();
		model.addState(new State(0.0, 0.0, 0.0, "1", "1"));
		Forward forward = new Forward();
		Constant left = new Constant();
		left.setInputValueOne(1.0);
		forward.setLeftChild(left);
		forward.evaluate(model);
		YCor yCor = new YCor();
		assertEquals(yCor.evaluate(model), 1.0, 0.0);
	}
}
