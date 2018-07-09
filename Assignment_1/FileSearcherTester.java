import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.assertEquals;

import java.io.*;		
import java.util.regex.*;

/**
* Tests whether the output of the FileIterator method in FileSearcher class returns the matching file or not
*/

@RunWith(JUnit4.class)
public class FileSearcherTester {
	
	@Test
	public static void main(String[] args)throws IOException {
		File[] files = new File("/home/zadmin/").listFiles();
		Pattern exp1 = Pattern.compile(".");
		Pattern exp2 = Pattern.compile("tcpdump.txt");
//		assertEquals(FileSearcher.fileIterator(files , exp1) , "/home/zadmin/networking/.vagrant/machines/default/virtualbox/id\n/home/zadmin/.mozilla/firefox/3fsbd4l1.default/storage/default/about+newtab/idb/3312185054sbndi_pspte.files/15\n");
		assertEquals(FileSearcher.fileIterator(files , exp2) , "/home/zadmin/Desktop/tcpdump.txt\n");
	}
}
