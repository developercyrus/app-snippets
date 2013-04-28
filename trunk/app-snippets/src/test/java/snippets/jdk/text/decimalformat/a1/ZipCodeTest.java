package snippets.jdk.text.decimalformat.a1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ZipCodeTest {

	@Test
	public void test() {
		String expected = "00123";
		String actual = ZipCode.convert(123);
		
		assertEquals(expected, actual);		
	}
}
