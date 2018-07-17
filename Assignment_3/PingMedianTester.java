import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.assertEquals;

import java.io.*;

/**
* Tests whether the output of the PingMedianFinder method in PingMedian class returns a double value or not.
*/

@RunWith(JUnit4.class)
public class PingMedianTester {
	
	@Test
	public static void main(String[] args)throws IOException {
		assertEquals(((Object)PingMedian.pingMedianFinder(3 , "www.google.com")).getClass().getSimpleName() , "Double");
	}
}
