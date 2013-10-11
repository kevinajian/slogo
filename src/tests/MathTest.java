package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import commands.basic_syntax.Constant;
import commands.math.*;

public class MathTest {

	@Test
	public void testSum() {
		Sum sum = new Sum();
		Constant left = new Constant();
		left.setInputValueOne(2.0);
		Constant right = new Constant();
		right.setInputValueOne(1.0);
		sum.setLeftChild(left);
		sum.setRightChild(right);
		assertEquals(sum.evaluate(null), 3.0, 0.02);
	}
	
	@Test
	public void testProduct() {
		Product product = new Product();
		Constant left = new Constant();
		left.setInputValueOne(7.0);
		Constant right = new Constant();
		right.setInputValueOne(3.0);
		product.setLeftChild(left);
		product.setRightChild(right);
		assertEquals(product.evaluate(null), 21.0, 0.02);
	}
	
	@Test
	public void testDifference() {
		Difference difference = new Difference();
		Constant left = new Constant();
		left.setInputValueOne(15.0);
		Constant right = new Constant();
		right.setInputValueOne(7.0);
		difference.setLeftChild(left);
		difference.setRightChild(right);
		assertEquals(difference.evaluate(null), 8.0, 0.02);
	}
	
	@Test
	public void testSin() {
		Sin sin = new Sin();
		Constant left = new Constant();
		left.setInputValueOne(30.0);
		sin.setLeftChild(left);
		assertEquals(sin.evaluate(null), 0.5, 0.02);
	}
	
	@Test
	public void testCos() {
		Cos cos = new Cos();
		Constant left = new Constant();
		left.setInputValueOne(60.0);
		cos.setLeftChild(left);
		assertEquals(cos.evaluate(null), 0.5, 0.02);
	}
	
	@Test
	public void testTan() {
		Tan tan = new Tan();
		Constant left = new Constant();
		left.setInputValueOne(50.0);
		tan.setLeftChild(left);
		assertEquals(tan.evaluate(null), 1.19, 0.02);
	}
	
	@Test
	public void testATan() {
		ATan aTan = new ATan();
		Constant left = new Constant();
		left.setInputValueOne(45.0);
		aTan.setLeftChild(left);
		assertEquals(aTan.evaluate(null), Math.atan(45.0), 0.02);
	}
	
	@Test
	public void testLog() {
		Log log = new Log();
		Constant left = new Constant();
		left.setInputValueOne(5.0);
		log.setLeftChild(left);
		assertEquals(log.evaluate(null), 1.61, 0.02);
	}
	
//	@Test
//	public void testPower() {
//		Power power = new Power();
//		power.setInputList(new ArrayList<Double>(){{add(24.0);}});
//		assertEquals(power.evaluate(), 1.19, 0.02);
//	}

}
