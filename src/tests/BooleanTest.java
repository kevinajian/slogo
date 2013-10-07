package tests;

import static org.junit.Assert.*;
import java.util.ArrayList;

import model.Model;
import model.State;

import org.junit.Test;
import commands.math.*;

public class BooleanTest {

	@Test
	public void testAnd() {
		Model model = new Model();
		model.addState(new State(0.0, 0.0, 0.0, "1", "1"));
		And and = new And();
		and.setInputList(new ArrayList<Double>(){{add(1.0); add(2.0);}});
		assertEquals(and.evaluate(null), 1.0, 0.0);
	}
	
	@Test
	public void testNotAnd() {
		Model model = new Model();
		model.addState(new State(0.0, 0.0, 0.0, "1", "1"));
		And and = new And();
		and.setInputList(new ArrayList<Double>(){{add(0.0); add(2.0);}});
		assertEquals(and.evaluate(null), 0.0, 0.0);
	}
	
	@Test
	public void testOr() {
		Model model = new Model();
		model.addState(new State(0.0, 0.0, 0.0, "1", "1"));
		Or or = new Or();
		or.setInputList(new ArrayList<Double>(){{add(0.0); add(2.0);}});
		assertEquals(or.evaluate(null), 1.0, 0.0);
	}
	
	@Test
	public void testNotOr() {
		Model model = new Model();
		model.addState(new State(0.0, 0.0, 0.0, "1", "1"));
		Or or = new Or();
		or.setInputList(new ArrayList<Double>(){{add(0.0); add(0.0);}});
		assertEquals(or.evaluate(null), 0.0, 0.0);
	}
	
	@Test
	public void testGreaterThan() {
		Model model = new Model();
		model.addState(new State(0.0, 0.0, 0.0, "1", "1"));
		Greater greater = new Greater();
		greater.setInputList(new ArrayList<Double>(){{add(37.0); add(9.0);}});
		assertEquals(greater.evaluate(null), 1.0, 0.0);
	}
	
	@Test
	public void testLessThan() {
		Model model = new Model();
		model.addState(new State(0.0, 0.0, 0.0, "1", "1"));
		Less less = new Less();
		less.setInputList(new ArrayList<Double>(){{add(3.0); add(15.0);}});
		assertEquals(less.evaluate(null), 1.0, 0.0);
	}

	@Test
	public void testEqualTo() {
		Model model = new Model();
		model.addState(new State(0.0, 0.0, 0.0, "1", "1"));
		Equal equal = new Equal();
		equal.setInputList(new ArrayList<Double>(){{add(11.0); add(11.0);}});
		assertEquals(equal.evaluate(null), 1.0, 0.0);
	}
	
	@Test
	public void testNotEqualTo() {
		Model model = new Model();
		model.addState(new State(0.0, 0.0, 0.0, "1", "1"));
		Equal equal = new Equal();
		equal.setInputList(new ArrayList<Double>(){{add(14.0); add(11.0);}});
		assertEquals(equal.evaluate(null), 0.0, 0.0);
	}
}