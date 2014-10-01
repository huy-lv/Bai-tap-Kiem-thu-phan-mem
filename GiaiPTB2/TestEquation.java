package GiaiPTB2;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TestEquation {

	@Test
	public void test1() {
		Equation a = new Equation(1, 2, 1);
		String expected = "x1=x2=-1.0";
		String actual = a.solve();
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void test2() {
		Equation a = new Equation(1, 4, 3);
		String expected = "x1=-1.0;x2=-3.0";
		String actual = a.solve();
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void test3() {
		Equation a = new Equation(1, 1, 1);
		String expected = "vo nghiem";
		String actual = a.solve();
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void test4() {
		Equation a = new Equation(0, 0, 0);
		String expected = "vo so nghiem";
		String actual = a.solve();
		Assert.assertEquals(expected, actual);
	}
}
