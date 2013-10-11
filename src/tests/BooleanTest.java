package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import model.Model;
import model.State;

import org.junit.Test;

import commands.basic_syntax.Constant;
import commands.math.*;

public class BooleanTest {

	@Test
	public void testAnd() {
		Model model = new Model();
		model.addState(new State(0.0, 0.0, 0.0, "1", "1"));
		And and = new And();
		Constant left = new Constant();
		left.setInputValueOne(1.0);
		Constant right = new Constant();
		right.setInputValueOne(2.0);
		and.setLeftChild(left);
		and.setRightChild(right);
		assertEquals(and.evaluate(null), 1.0, 0.0);
		
		left.setInputValueOne(0.0);
		right.setInputValueOne(2.0);
		assertEquals(and.evaluate(null), 0.0, 0.0);
	}
	
	@Test
	public void testOr() {
		Model model = new Model();
		model.addState(new State(0.0, 0.0, 0.0, "1", "1"));
		Or or = new Or();
		Constant left = new Constant();
		left.setInputValueOne(0.0);
		or.setLeftChild(left);
		Constant right = new Constant();
		right.setInputValueOne(20.0);
		or.setRightChild(right);
		assertEquals(or.evaluate(null), 1.0, 0.0);
		
		left.setInputValueOne(0.0);
		right.setInputValueOne(0.0);
		assertEquals(or.evaluate(null), 0.0, 0.0);
	}

	@Test
	public void testGreaterThan() {
		Model model = new Model();
		model.addState(new State(0.0, 0.0, 0.0, "1", "1"));
		Greater greater = new Greater();
		Constant left = new Constant();
		left.setInputValueOne(37.0);
		greater.setLeftChild(left);
		Constant right = new Constant();
		right.setInputValueOne(9.0);
		greater.setRightChild(right);
		assertEquals(greater.evaluate(null), 1.0, 0.0);
		
		left.setInputValueOne(2.0);
		right.setInputValueOne(8.0);
		assertEquals(greater.evaluate(null), 0.0, 0.0);
	}
	
	@Test
	public void testLessThan() {
		Model model = new Model();
		model.addState(new State(0.0, 0.0, 0.0, "1", "1"));
		Less less = new Less();
		Constant left = new Constant();
		left.setInputValueOne(3.0);
		less.setLeftChild(left);
		Constant right = new Constant();
		right.setInputValueOne(15.0);
		less.setRightChild(right);
		assertEquals(less.evaluate(null), 1.0, 0.0);
		
		left.setInputValueOne(15.0);
		right.setInputValueOne(3.0);
		assertEquals(less.evaluate(null), 0.0, 0.0);
	}

	@Test
	public void testEqualTo() {
		Model model = new Model();
		model.addState(new State(0.0, 0.0, 0.0, "1", "1"));
		Equal equal = new Equal();
		Constant left = new Constant();
		left.setInputValueOne(11.0);
		equal.setLeftChild(left);
		Constant right = new Constant();
		right.setInputValueOne(11.0);
		equal.setRightChild(right);
		assertEquals(equal.evaluate(null), 1.0, 0.0);
		
		left.setInputValueOne(12.0);
		assertEquals(equal.evaluate(null), 0.0, 0.0);
	}
}