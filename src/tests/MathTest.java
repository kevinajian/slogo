package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import commands.math.Sum;

public class MathTest {

	@Test
	public void testSum() {
		Sum sum = new Sum();
		sum.setInputList(new ArrayList<Double>(){{add(1.0); add(2.0);}});
		assertEquals(sum.evaluate(), 3.0, 0.0);
	}

}
