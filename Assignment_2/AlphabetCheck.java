import java.io.*;
import java.util.*;

class AlphabetCheck {

/**
* Takes a string as input from the user and checks to see if it has all the alphabets present in it.
* Ignores case.
*/
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the string to be checked");		//User Prompt
		String str = br.readLine().toLowerCase();		//Reading the user input and converting it to lowercase
		if(alphaCheck(str))
			System.out.println("String contains all alphabets.");
		else
			System.out.println("String does not contain all alphabets.");
	}
	
	/**
	* Takes a String as the only argument and converts it into a char array and checks each element to see if all the alphabets have been
	* encountered.
	* Returns true if all the alphabets have been encountered, false otherwise.
	* 
	* @param str String storing the input by the user
	*/
	
	public static boolean alphaCheck(String str) {
		if(str == null) {
			throw new NullPointerException("Input has a null value.");
		}
		HashMap<Character, Boolean> alpha = new HashMap<>();		//Declaring hash table to hold alphabets and their occurence
		for(char i : str.toCharArray()) {		//Converting string to array of characters and iterating over it
			if((int)i >= 97 && (int)i <= 122)		//Checking if the ASCII value falls in the range of alphabets
				alpha.put(i , true);
		}
		if(alpha.size() == 26)		//Checking if all alphabets have been encountered
			return true;
		else
			return false;
	}
}

//	The space complexity of the program is O(n).
//	The time complexity of the program is O(n).
