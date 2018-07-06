import java.io.*;
import java.util.*;

class Alphabets {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the string to be checked");		//User Prompt
		String str = br.readLine().toLowerCase();		//Reading the user input and converting it to lowercase
		HashMap<Character, Boolean> alpha = new HashMap<>();		//Declaring hash table to hold alphabets and their occurence
		for(char i : str.toCharArray()) {		//Converting string to array of characters and iterating over it
			if((int)i >= 97 && (int)i <= 122)		//Checking if the ASCII value falls in the range of alphabets
				alpha.put(i , true);
		}
		if(alpha.size() == 26)		//Checking if all alphabets have been encountered
			System.out.println("String contains all alphabets.");
		else
			System.out.println("String does not contain all alphabets.");
	}
}

//	The space complexity of the program is O(n).
//	The time complexity of the program is O(n).
