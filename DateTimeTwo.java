import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map.Entry;

// Generated
public class DateTimeTwo {
	
	// The current date and time
	private final LocalDate CURRTIME = LocalDate.now();
	
	// HashMap that will contain all the dates from Dates.txt
	private HashMap <LocalDate, Integer> datesFileMap = new HashMap <LocalDate, Integer>();
	
	// Treemap that will hold the corrected sorted values
	private TreeMap <LocalDate, Integer> sortedMap = new TreeMap<> (datesFileMap);
	
	// Constructor
	public DateTimeTwo() {
		
	}

	// Method to calculate the 10th and 18th day of current user's month
	public void daysOfCurrentMonth() {
		
		// Format for the day of the month
		DateTimeFormatter dayOfMonth = DateTimeFormatter.ofPattern("EEEE");
		
		// Assign the 10th day of the month
		LocalDate ten = CURRTIME.withDayOfMonth(10);
		
		// Assign the 18th day of the month
		LocalDate eigthteen = CURRTIME.withDayOfMonth(18);
		
		// String representing the 10th day
		String tenthDay = ten.format(dayOfMonth).toUpperCase();
		
		// String representing the 18th day
		String eighteenthtDay = eigthteen.format(dayOfMonth).toUpperCase();
		
		// Output
		System.out.println("The tenth day of this month is " + tenthDay + " and eighteenth is " + eighteenthtDay);
	}

	// Getting the 15th and last day of the user's month and year
	public void daysOfAnyMonth(int i, int j) {
		
		int month = i;
		int year = j;
		
		// Format for the day of the month
		DateTimeFormatter dayOfMonth = DateTimeFormatter.ofPattern("EEEE");
		
		// Getting the date and month of user's input
		LocalDateTime userDate = LocalDateTime.of(year, month, 1, 1, 1);
		
		// Getting the last day of the user's month
		LocalDateTime lastDate = userDate.withDayOfMonth(userDate.getMonth().maxLength());
		
		// Getting the 15th day of the user's month
		LocalDateTime fifteenthDay = userDate.withDayOfMonth(15);
		
		String fifteenthDayStr = fifteenthDay.format(dayOfMonth).toUpperCase();
		
		String lastDay = lastDate.format(dayOfMonth).toUpperCase();
		
		System.out.println("For the year (" + year + ") and month (" + month + "), the fifteenth day is " + fifteenthDayStr
							+ " and the last day is " + lastDay);
	}

	// Method that reads in Dates.txt and finds if year is leap year or not
	public void compareYear() throws IOException {

		// Read file with bufferReader //
		BufferedReader br = new BufferedReader(new FileReader("Dates.txt"));
		
		// Format for the day of the month
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM.dd.yyyy");

		// String representing current line being read by bufferedReader
		String currLine;
		
		// Iterator
		int i = 0;
		
		// Putting dates into datesFileMap hashMap
		while((currLine = br.readLine()) != null) {
			
			// Increment the iterator
			i++;
			
			// Parsing current line into the format we need it in
			LocalDate currDate = LocalDate.parse(currLine, dateFormat);
				
			// Placing those formatted lines in our HashMap
			datesFileMap.put(currDate, i);
		}
		
		// Close reader (finished reading file)
		br.close();	
		
		for (LocalDate key: datesFileMap.keySet()) {
			
			// Calculate the difference between the key's date and the user's years
			
			// Find the difference of date between the user and key
			Period Difference = Period.between(CURRTIME, key);
			
			// Store the difference of years into an int
			int diffYear = Difference.getYears();
			
			// Store the difference of months into an int
			int diffMont = Difference.getMonths();
			
			// Store the difference of days into an int
			int diffDay = Difference.getDays();
			
			// Checking for leap //
			
			// Current year pulled from datesFileMap key to compare with user's current year
			Year currYear = Year.of(key.getYear());
			
			// Variable that represents if the current year of the hashmap is leap or nah
			boolean leapOrNah = currYear.isLeap();
			
			// Check if key year is leap or nah
			if (leapOrNah == true) {
				System.out.println(currYear + " is a leap year, and Difference: " + Math.abs(diffYear) + " years, "
									+ Math.abs(diffMont) + " months, and " + Math.abs(diffDay) + " days.");
			} else {
				System.out.println(currYear + " is not a leap year, and Difference: " + Math.abs(diffYear) + " years, "
									+ Math.abs(diffMont) + " months, and " + Math.abs(diffDay) + " days.");
			}
		}
	}

	// Method to print out the hash map
	public void dateHashMap() {
		
		for (LocalDate currentKey: datesFileMap.keySet()) {
			
			System.out.println(currentKey + ":" + datesFileMap.get(currentKey));
		}
	}

	// Method to sort the hash map and output in sorted order
	public void dateHashMapSorted() {
		
		// Store hashmap values into tree map
		sortedMap = new TreeMap<>(datesFileMap);
		
		// "Now the Hashmap"
		for (LocalDate key: sortedMap.keySet()) {
			
		    System.out.println(key + ":" + sortedMap.get(key));
		}
	}
// end
}