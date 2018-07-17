import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.*;		
import java.util.regex.*;

/**
* Tests whether the output of the FileIterator method in FileSearcher class returns the matching file or not
*/

public class FileSearcherTester {
	
	@Test
	public void fileIteratorTest()throws IOException {
		File[] files = new File("/home/zadmin/").listFiles();
		Pattern exp1 = Pattern.compile("..");
		Pattern exp2 = Pattern.compile("tcpdump.txt");
		FileSearcher obj = new FileSearcher();
		assertEquals(obj.fileIterator(files , exp2) , "/home/zadmin/Desktop/tcpdump.txt\n");
	}
}
