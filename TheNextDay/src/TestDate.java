import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;


public class TestDate {

	@Test
	public void test() {
		Date a = new Date(28,2,100);
		Date expected = new Date(1,3,100);
		Date actual = a.nextDay();
		Assert.assertEquals(expected.ToString(), actual.ToString());
		
	}

}
