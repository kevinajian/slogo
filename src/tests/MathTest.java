package tests;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import commands.math.*;

public class MathTest {

	@Test
	public void testSum() {
		Sum sum = new Sum();
		sum.setInputList(new ArrayList<Double>(){{add(1.0); add(2.0);}});
		assertEquals(sum.evaluate(null), 3.0, 0.02);
	}
	
	@Test
	public void testProduct() {
		Product product = new Product();
		product.setInputList(new ArrayList<Double>(){{add(7.0); add(3.0);}});
		assertEquals(product.evaluate(null), 21.0, 0.02);
	}
	
	@Test
	public void testDifference() {
		Difference difference = new Difference();
		difference.setInputList(new ArrayList<Double>(){{add(15.0); add(7.0);}});
		assertEquals(difference.evaluate(null), 8.0, 0.02);
	}
	
	@Test
	public void testSin() {
		Sin sin = new Sin();
		sin.setInputList(new ArrayList<Double>(){{add(30.0);}});
		assertEquals(sin.evaluate(null), 0.5, 0.02);
	}
	
	@Test
	public void testCos() {
		Cos cos = new Cos();
		cos.setInputList(new ArrayList<Double>(){{add(60.0);}});
		assertEquals(cos.evaluate(null), 0.5, 0.02);
	}
	
	@Test
	public void testTan() {
		Tan tan = new Tan();
		tan.setInputList(new ArrayList<Double>(){{add(50.0);}});
		assertEquals(tan.evaluate(null), 1.19, 0.02);
	}
	
//	@Test
//	public void testATan() {
//		ATan atan = new ATan();
//		atan.setInputList(new ArrayList<Double>(){{add(45.0);}});	
//		System.out.println(atan.evaluate());
//		assertEquals(atan.evaluate(), 0.67, 0.02);
//	}
	
	@Test
	public void testLog() {
		Log log = new Log();
		log.setInputList(new ArrayList<Double>(){{add(5.0);}});
		assertEquals(log.evaluate(null), 1.61, 0.02);
	}
	
//	@Test
//	public void testPower() {
//		Power power = new Power();
//		power.setInputList(new ArrayList<Double>(){{add(24.0);}});
//		assertEquals(power.evaluate(), 1.19, 0.02);
//	}

}
