import java.util.regex.*;
import java.io.*;
class Test_1 {
	
	public static void posTest() {
		String[] posTest = {"." , ".." , ".*" , ".*ell.*" , "hello.*" , ".*\\.jpg" , "tcpdump.txt" , "tcpdumpz?.txt"};
		File[] files = new File("/home/zadmin/").listFiles();
		for(String test : posTest) {
			Pattern exp = Pattern.compile(test);
			Search.fileIterator(files, exp);
			System.out.println("\n\n\n\n");
		}
	}
	
	public static void negTest() {
		String[] negTest = {"*" , "Hi"};
		File[] files = new File("/home/zadmin/").listFiles();
		for(String test : negTest) {
			try {
				Pattern exp = Pattern.compile(test);
				Search.fileIterator(files, exp);
				System.out.println("\n\n\n\n");
			} catch (Exception e) {
				System.out.println(e + "\n\n\n\n");
				continue;
			}
		}	
	}
	
	public static void main(String[] args) {
		System.out.println("Positive Test Cases\n");
		posTest();
		System.out.println("Negative Test Cases\n");
		negTest();
	}
}
