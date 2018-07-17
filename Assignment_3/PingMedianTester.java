import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.*;

/**
* Tests whether the output of the PingMedianFinder method in PingMedian class returns a double value or not.
*/

public class PingMedianTester {
	
	@Test
	public void tester()throws IOException {
		PingMedian obj = new PingMedian();
		assertEquals(((Object)obj.pingMedianFinder(3 , "www.google.com")).getClass().getSimpleName() , "Double");
	}
}
