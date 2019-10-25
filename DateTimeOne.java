import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class DateTimeOne extends MesoDateTimeOneAbstract
{
	private HashMap <String, String> firstMap = new HashMap <String, String>();
	
	private HashMap <String, String> secondMap = new HashMap <String, String>();
	
	private static final int MILLI_CONVERSION = 1000;
	private int currSec;
	private int second;
	private long milli;
	private LocalDateTime currTime = LocalDateTime.now();
	
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
		
		currSec = second % 60;
		System.out.println("The value of the Second now: " + currSec);
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

	// Method to calculate server time and time zones in HH:mm and put in hmap
	@Override
	void dateTimeOfOtherCity() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		
		// Time on server
		String strServer = formatter.format(currTime);
		//TEST//
		System.out.println("Time on Server: " + strServer);
		
		// For GMT time zone
		LocalDateTime gmtTime = currTime.plusHours(5);
		String gmtTimeStr = formatter.format(gmtTime);
		System.out.println("GMT: " + gmtTimeStr);
		
		// For BST time zone
		LocalDateTime bstTime = currTime.plusHours(6);
		String bstTimeStr = formatter.format(bstTime);
		System.out.println("BST (90E): " + bstTimeStr);
		
		// For CST time zone
		LocalDateTime cstTime = gmtTime.minusHours(5);
		String cstTimeStr = formatter.format(cstTime);
		System.out.println("CST (90W): " + cstTimeStr);
	}

	// Method to calculate server time and time zones in MM/dd/yyyy HH:mm and put in hmap
	@Override
	void dateTimeDifferentZone() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
		
		// for GMT
		LocalDateTime gmtTime = currTime.plusHours(5);
		String gmtTimeStr = formatter.format(gmtTime);
		System.out.println("GMT: " + gmtTimeStr);
		
		// for BST
		LocalDateTime bstTime = currTime.plusHours(6);
		String bstTimeStr = formatter.format(bstTime);
		System.out.println("BST: " + bstTimeStr); 
		
		// For CST time zone
		LocalDateTime cstTime = gmtTime.minusHours(5);
		String cstTimeStr = formatter.format(cstTime);
		System.out.println("CST: " + cstTimeStr);
	}

	@Override
	void timeZoneHashMap() {
		
		String zst = "11/05/2018 10:59";
		String ast = "10/01/2020 19:59";
		
		firstMap.put("ZST", zst);
		firstMap.put("AST", ast);
		
		System.out.println("Print Style 1:");
		Iterator<String> itr = firstMap.keySet().iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}
// end 
}