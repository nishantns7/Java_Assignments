import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import java.time.Period;

public class KycRangeTester {
	
	public static void main(String[] args) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate entryDate[] = new LocalDate[1];
		LocalDate currentDate[] = new LocalDate[1];
		entryDate[0] = LocalDate.parse("16-07-1998" , formatter);
		currentDate[0] = LocalDate.parse("27-06-2017" , formatter);
		assert KycRange.RangeFinder(entryDate , currentDate , 1 , formatter).equals("16-06-2017 27-06-2017");
	}
}
