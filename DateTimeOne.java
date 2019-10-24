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
	// hmap of HH:mm
	private HashMap <String, String> timeZone = new HashMap <String, String>();
	
	// hmap of MM/dd/yyyy HH:mm
	private HashMap <String, String> otherZone = new HashMap <String, String>();
	
	private static final int MILLI_CONVERSION = 1000;
	private int currSec;
	private int second;
	private long milli;
	
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

	// Method to calculate server time and time zones
	@Override
	void dateTimeOfOtherCity() {
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		
		// Time on server
		String strServer = formatter.format(date);
		//TEST//
		System.out.println("Time on Server: " + strServer);
		
		// For GMT time zone
		TimeZone gmtTimeZone = TimeZone.getTimeZone("GMT");
		String gmt = formatter.format(date);
		formatter.setTimeZone(gmtTimeZone);
		System.out.println("GMT: " + formatter.format(date));
		
		// For BST time zone
		TimeZone bstTimeZone = TimeZone.getTimeZone("BST");
		String bst = formatter.format(date);
		formatter.setTimeZone(bstTimeZone);
		System.out.println("BST (90E): " + formatter.format(date));
		
		// For BST time zone
		TimeZone cstTimeZone = TimeZone.getTimeZone("CST");
		String cmt = formatter.format(date);
		formatter.setTimeZone(cstTimeZone);
		System.out.println("CST (90W): " + formatter.format(date));
		
		// Putting <String, String> values with assigned keys in timeZone hmap
		timeZone.put("GMT", gmt);
		timeZone.put("BST", bst);
		timeZone.put("CST", cmt);
	}

	@Override
	void dateTimeDifferentZone() {
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		
		TimeZone gmtTimeZone = TimeZone.getTimeZone("GMT");
		String gmt = formatter.format(date);
		formatter.setTimeZone(gmtTimeZone);
		System.out.println("GMT: " + formatter.format(date));
		
		TimeZone bstTimeZone = TimeZone.getTimeZone("BST");
		String bst = formatter.format(date);
		formatter.setTimeZone(bstTimeZone);
		System.out.println("BST: " + formatter.format(date));
		
		TimeZone cmtTimeZone = TimeZone.getTimeZone("CST");
		String cmt = formatter.format(date);
		formatter.setTimeZone(cmtTimeZone);
		System.out.println("CST: " + formatter.format(date));
		
		// Putting <String, String> values with assigned keys in otherZone hmap
		otherZone.put("GMT", gmt);
		otherZone.put("BST", bst);
		otherZone.put("CST", cmt);	
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