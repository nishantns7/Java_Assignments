import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import java.time.Period;

public class KycRangeTester {
	
	@Test
	public void rangeFinderTest() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate entryDate[] = new LocalDate[5];
		LocalDate currentDate[] = new LocalDate[5];
		KycRange obj = new KycRange();
		entryDate[0] = LocalDate.parse("16-07-1998" , formatter);
		currentDate[0] = LocalDate.parse("27-06-2017" , formatter);
		entryDate[1] = LocalDate.parse("04-02-2016" , formatter);
		currentDate[1] = LocalDate.parse("04-04-2017" , formatter);
		entryDate[2] = LocalDate.parse("04-05-2017" , formatter);
		currentDate[2] = LocalDate.parse("04-04-2017" , formatter);
		entryDate[3] = LocalDate.parse("04-04-2015" , formatter);
		currentDate[3] = LocalDate.parse("04-04-2016" , formatter);
		entryDate[4] = LocalDate.parse("04-04-2015" , formatter);
		currentDate[4] = LocalDate.parse("15-03-2016" , formatter);
		assertEquals(obj.rangeFinder(entryDate , currentDate , 5 , formatter),"16-06-2017 27-06-2017\n05-01-2017 06-03-2017\nNo range\n05-03-2016 04-04-2016\n05-03-2016 15-03-2016\n");
	}
}
