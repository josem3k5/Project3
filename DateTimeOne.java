import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class DateTimeOne extends MesoDateTimeOneAbstract
{
	private HashMap <String, String> timeZone = new HashMap <String, String>();
	private int currSec;
	private int second;
	private long milli;
	private int minute;
	private int currMin;
	private int hour;
	private int currHour;
	private static final int MILLI_CONVERSION = 1000;
	
	// Constructor
	public DateTimeOne () {
		
		milli = System.currentTimeMillis();
		second = (int) milli / MILLI_CONVERSION;
	}
	
	public DateTimeOne(long input) {
		
		milli = input;
	}
	
	// Return the current second
	@Override
	int getValueOfSecond() {
		
		currSec = -1 * second % 60;
		
		return currSec;
	}

	@Override
	void dateTimeNow() {
		// OUTPUT FORMAT: Current Date/Time: 10/10/2019 06:24 PM
		
		// Getting minutes
		minute = currSec / 60;
		
		// Getting current minute
		currMin = minute % 60;
		
		// Getting hour
		hour = minute / 60;
		
		// Getting current hour
		currHour = hour % 24;
	}

	// Method causing program to sleep for 5 seconds if currSec is greater then allowedSec
	@Override
	void sleepForFiveSec() {
		
		try {
			
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	void dateTimeOfOtherCity() {
		// TODO Auto-generated method stub
	}

	@Override
	void dateTimeDifferentZone() {
		// TODO Auto-generated method stub
	}

	@Override
	void timeZoneHashMap() {
		// TODO Auto-generated method stub
	}
	
	/*
	 * Method to read in file (Dates.txt)
	 */
	public void readFile() throws IOException {

		// Read file with bufferReader
		BufferedReader br = new BufferedReader(new FileReader("SortingDates.txt"));

		// String representing current line being read by bufferedReader
		String currLine;

		// Begin to read every line where information starts (line 7) as long as line != null
		while((currLine = br.readLine()) != null) {

			// Trim out white space of current line
			String stationTrimmed = currLine.trim();

			// Adding each station name to ArrayList, STIDnames
			timeZone.put(currLine,  currLine);
		}
		// Close reader
		br.close();
	}
   
   
   
   
   
// end 
}