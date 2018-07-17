import java.io.*;		
import java.util.regex.*;

/**
* Searches through all directories and sub-directories to locate files which conform to the regular expression input by the user.
* Then returns the absolute path of all the files found to be matching the regular expression
*/

class FileSearcher {

	static String result = "";
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		//Initializing the buffered reader
		while(true) {		//Repeats execution until user aborts
			System.out.print("Enter the regular Expression or ' ' to abort: ");		//User Prompt
			String input = br.readLine();		
			if(input.equals(" "))
				break;		//Ends execution if user inputs " "
			else {
				File[] files= new File("/home/zadmin/").listFiles();		//Creates an array of files in /home/zadmin/
				Pattern exp = Pattern.compile(input);		//sets the regular expression as the one input by the user
				System.out.println(fileIterator(files, exp));		//Calls the function to search through the files in the current dir
			}
		}
	}
	
	/*
	* Takes the file list in a directory and the regular expression as the arguments and searches for matches within that directory.
	* Recursively calls itself if a directory is encountered within the current directory
	* Returns the list of matching files
	* @param files an array of File type containing the files of the current directory
	* @param exp an object of the Pattern class containing the regular expression to be matched against
	*/
	
	public static String fileIterator(File[] files, Pattern exp) {
		if(exp == null)
			throw new IllegalArgumentException("Pattern object should not have null value.");
		for(File file: files) {		//iterates through each file in the directory
			if(file == null)
				throw new IllegalArgumentException("File object should not have null value.");
			if(file.isDirectory())		//checks if the current file is a sub-directory
				fileIterator(file.listFiles(), exp);		//calls the function to search through files in the sub dir
			else {
				Matcher m = exp.matcher(file.getName());		//Compares the file name with the regular expression
				if(m.matches()) {
					result = result + file.getAbsolutePath() + "\n";		//prints the full path if the name matches
				}
			}
		}
		return result;
	}
}
