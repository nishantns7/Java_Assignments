import java.io.*;		
import java.util.regex.*;

class Search {
	
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
				fileIterator(files, exp);		//Calls the function to search through the files in the current dir
			}
		}
	}
	public static void fileIterator(File[] files, Pattern exp) {
		for(File file: files) {		//iterates through each file in the directory
			if(file.isDirectory())		//checks if the current file is a sub-directory
				fileIterator(file.listFiles(), exp);		//calls the function to search through files in the sub dir
			else {
				Matcher m = exp.matcher(file.getName());		//Compares the file name with the regular expression
				if(m.matches())
					System.out.println(file.getAbsolutePath());		//prints the full path if the name matches
			}
		}
	}
}
