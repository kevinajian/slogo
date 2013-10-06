package tests;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import commands.math.*;

public class BooleanTest {

	@Test
	public void testAnd() {
		And and = new And();
		and.setInputList(new ArrayList<Double>(){{add(1.0); add(2.0);}});
		assertEquals(and.evaluate(null), 1.0, 0.0);
	}
	
	@Test
	public void testNotAnd() {
		And and = new And();
		and.setInputList(new ArrayList<Double>(){{add(0.0); add(2.0);}});
		assertEquals(and.evaluate(null), 0.0, 0.0);
	}
	
	@Test
	public void testOr() {
		Or or = new Or();
		or.setInputList(new ArrayList<Double>(){{add(0.0); add(2.0);}});
		assertEquals(or.evaluate(null), 1.0, 0.0);
	}
	
	@Test
	public void testNotOr() {
		Or or = new Or();
		or.setInputList(new ArrayList<Double>(){{add(0.0); add(0.0);}});
		assertEquals(or.evaluate(null), 0.0, 0.0);
	}
	
	@Test
	public void testGreaterThan() {
		Greater greater = new Greater();
		greater.setInputList(new ArrayList<Double>(){{add(37.0); add(9.0);}});
		assertEquals(greater.evaluate(null), 1.0, 0.0);
	}
	
	@Test
	public void testLessThan() {
		Less less = new Less();
		less.setInputList(new ArrayList<Double>(){{add(3.0); add(15.0);}});
		assertEquals(less.evaluate(null), 1.0, 0.0);
	}

	@Test
	public void testEqualTo() {
		Equal equal = new Equal();
		equal.setInputList(new ArrayList<Double>(){{add(11.0); add(11.0);}});
		assertEquals(equal.evaluate(null), 1.0, 0.0);
	}
	
	@Test
	public void testNotEqualTo() {
		Equal equal = new Equal();
		equal.setInputList(new ArrayList<Double>(){{add(14.0); add(11.0);}});
		assertEquals(equal.evaluate(null), 0.0, 0.0);
	}
}