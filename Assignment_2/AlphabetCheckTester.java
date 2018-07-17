import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
* Tests whether the output of the alphaCheck method in AlphabetCheck class returns true or not.
*/

public class AlphabetCheckTester {
	
	@Test
	public void tester() {
		AlphabetCheck obj = new AlphabetCheck();
		assertTrue(obj.alphaCheck("The quick brown fox jumps over the lazy dog"));
	}
}
