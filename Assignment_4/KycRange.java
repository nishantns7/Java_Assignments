import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import java.time.Period;

/**
* Takes two sets of dates as inputs, the join date of the customer and the current date.
* Prints out the valid range of dates the customer can sign the forms with, subject to the conditions.
* The range will be 30 days on either side of the anniversary date, not counting the year of joining itself.
* If the mentioned range falls in the future with respect to the input current date, the customer will have to sign for the previous year   * date.
*/
class KycRange {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of entries followed by the entries.");
		int n = Integer.parseInt(br.readLine());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");				//Setting the format of the date
		LocalDate entryDate[] = new LocalDate[n];
		LocalDate currentDate[] = new LocalDate[n];
		for (int i = 0; i < n; i++) {
			String[] entries = br.readLine().split(" ", 0);				//Splitting the two dates
			entryDate[i] = LocalDate.parse(entries[0] , formatter);				//Storing the first half of the strings as the signup dates
			currentDate[i] = LocalDate.parse(entries[1] , formatter);				//Storing the second half of the strings as the current dates
		}
		System.out.println(rangeFinder(entryDate, currentDate, n, formatter));
	}

	/**
	* Prints out a range of possible dates for the user to sign the KYC forms for each set of signup-current date pairs passed to the method.
	* Prints the date in dd-MM-yyyy format
	* 
	* @param entryDate an array containing all the signup dates in the input
	* @param currentDate an array containing all the current dates in the input
	* @param n integer containing the number of entries
	* @param formatter DateTimeFormatter object containing the format for date storage
	*/
	public static String rangeFinder(LocalDate[] entryDate, LocalDate[] currentDate, int n, DateTimeFormatter formatter) {
		String range = "";
		for (int i = 0; i < n; i++) {
			if(entryDate[i] == null || currentDate[i] == null)
				throw new IllegalArgumentException("Dates cannot have a null value.");
			if (entryDate[i].isAfter(currentDate[i]) || ChronoUnit.DAYS.between(entryDate[i], currentDate[i]) < 336)
				range += "No range\n";
			else {
				entryDate[i] = entryDate[i].plus(currentDate[i].getYear() - entryDate[i].getYear(), ChronoUnit.YEARS);
				LocalDate lowerDate = entryDate[i].minus(30, ChronoUnit.DAYS);
				LocalDate upperDate = entryDate[i].plus(30, ChronoUnit.DAYS);
				if(upperDate.isAfter(currentDate[i])) {
					upperDate = currentDate[i];
				}
				range += lowerDate.format(formatter) + " " + upperDate.format(formatter) + "\n";
			}
		}
		return range;
	}
}
