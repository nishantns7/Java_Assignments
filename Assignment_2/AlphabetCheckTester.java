import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.assertTrue;

/**
* Tests whether the output of the alphaCheck method in AlphabetCheck class returns true or not.
*/

@RunWith(JUnit4.class)
public class AlphabetCheckTester {
	
	@Test
	public static void main(String[] args) {
		assertTrue(AlphabetCheck.alphaCheck("The quick brown fox jumps over the lazy dog"));
	}
}
