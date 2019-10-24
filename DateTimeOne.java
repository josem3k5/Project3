import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class DateTimeOne extends MesoDateTimeOneAbstract
{
	private HashMap <String, String> timeZone = new HashMap <String, String>();
	private int currSec;
	private int second;
	private long milli;
	private static final int MILLI_CONVERSION = 1000;
	
	// Constructor
	public DateTimeOne () {
		
		milli = System.currentTimeMillis();
		second = (int) milli / MILLI_CONVERSION;
	}
	
//	public DateTimeOne(long input) {
//		
//		milli = input;
//	}
	
	// Return the current second
	@Override
	int getValueOfSecond() {
		
		currSec = -1 * second % 60;
		
		return currSec;
	}

	@Override
	void dateTimeNow() {
		
		Date date = new Date();
		
		// Current date and time
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm a");  
		String strDate = formatter.format(date);
		//TEST//
		System.out.println("Current Date/Time: " + strDate);
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
		
		Date date = new Date();
		
		// Time on server
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");  
		String strServer = formatter.format(date);
		//TEST//
		System.out.println("Time on Server: " + strServer);
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

		// For GMT time zone
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		//Will print in GMT TEST
		System.out.println("GMT: " + sdf.format(calendar.getTime()));
		
		// For BST time zone
		sdf.setTimeZone(TimeZone.getTimeZone("BST"));
		//Will print in GMT TEST
		System.out.println("BST (90E): " + sdf.format(calendar.getTime()));
		
		// For CST time zone
		sdf.setTimeZone(TimeZone.getTimeZone("CST"));
		//Will print in GMT TEST
		System.out.println("CST (90W): " + sdf.format(calendar.getTime()));
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