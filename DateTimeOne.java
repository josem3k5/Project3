import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class DateTimeOne extends MesoDateTimeOneAbstract
{
	private HashMap <String, String> firstMap = new HashMap <String, String>();
	
	private HashMap <String, String> secondMap = new HashMap <String, String>();
	
	// int representing the current second of user
	private int currSec;
	
	// LocalDateTime representing the second
	private LocalDateTime second;
	
	private long milli;
	
	// LocalDateTime representing the current/ now time of the computer
	private LocalDateTime currTime = LocalDateTime.now();
	
	// LocalDateTime to hold the gmt time
	LocalDateTime gmtTime;
	
	// LocalDateTime to hold the bst time
	LocalDateTime bstTime;
	
	// LocalDateTime to hold the cst time
	LocalDateTime cstTime;
	
	// String representing the gmt time in String
	String gmtTimeStr;
	
	// String representing the bst time in String
	String bstTimeStr;
	
	// String representing the cst time in String
	String cstTimeStr;
	
	// Constructor
	public DateTimeOne () {
		
		milli = System.currentTimeMillis();
		
		second = LocalDateTime.now();
	}
	
	// Return the current second
	@Override
	int getValueOfSecond() {
		
		currSec = second.getSecond();
		System.out.println("The value of the Second now: " + currSec);
		return currSec;
	}

	// Method that grabs the current time of the computer and puts in the SimpleDateFormat format
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
		gmtTime = currTime.plusHours(5);
		gmtTimeStr = formatter.format(gmtTime);
		System.out.println("GMT: " + gmtTimeStr);
		
		// For BST time zone
		bstTime = currTime.plusHours(6);
		bstTimeStr = formatter.format(bstTime);
		System.out.println("BST (90E): " + bstTimeStr);
		
		// For CST time zone
		cstTime = gmtTime.minusHours(5);
		cstTimeStr = formatter.format(cstTime);
		System.out.println("CST (90W): " + cstTimeStr);
	}

	// Method to calculate server time and time zones in MM/dd/yyyy HH:mm and put in hmap
	@Override
	void dateTimeDifferentZone() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
		
		// for GMT
		gmtTime = currTime.plusHours(5);
		gmtTimeStr = formatter.format(gmtTime);
		System.out.println("GMT: " + gmtTimeStr);
		
		// for BST
		bstTime = currTime.plusHours(6);
		bstTimeStr = formatter.format(bstTime);
		System.out.println("BST: " + bstTimeStr); 
		
		// For CST time zone
		cstTime = gmtTime.minusHours(5);
		cstTimeStr = formatter.format(cstTime);
		System.out.println("CST: " + cstTimeStr);
		
		firstMap.put("GMT", gmtTimeStr);
		firstMap.put("BST", bstTimeStr);
		firstMap.put("CST", cstTimeStr);
	}

	@Override
	void timeZoneHashMap() {
		
		// Previous DateTimeFormatter
		DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
		
		String zst = "11/05/2018 10:59";
		String ast = "10/01/2020 19:59";
		
		firstMap.put("ZST", zst);
		firstMap.put("AST", ast);
		
		// TreeMap to use for sorting date and time
		TreeMap <String, String> sortedP1 = new TreeMap<> (firstMap);
		
		// Putting all data from PrintStyle1 into tree
		sortedP1.putAll(firstMap);
		
		// For Print Style 1
		System.out.println("Print Style 1:");
		for (String key : sortedP1.keySet()) {
		    System.out.println(key + " " + firstMap.get(key));
		}
		
		// For Print Style 3
		secondMap.put(gmtTimeStr, null);
		secondMap.put(bstTimeStr, null);
		secondMap.put(cstTimeStr, null);
		secondMap.put(zst, null);
		secondMap.put(ast, null);
		
		TreeMap <String, String> sortedMap = new TreeMap<>(secondMap);
		
		// TreeMap to use for sorting date and time
		Set <Entry <String, String>> sortedP2 =  sortedMap.entrySet();
				
		// Putting all data from PrintStyle1 into tree
		sortedP1.putAll(secondMap);
		
		System.out.println("Print Style 3:");
		for (Entry<String, String> key : sortedP2) {
		    System.out.println(key.getKey());
		}
		
		// For Print Style 5
		System.out.println("Print Style 5: Final sorted Array:");
		
		// Array of size matching second hash map
		LocalDateTime[] p5 = new LocalDateTime[secondMap.size()];
		
		// Converting String to LocalDateTime
		LocalDateTime astTime = LocalDateTime.parse(ast, inputFormat);
		LocalDateTime zstTime = LocalDateTime.parse(zst, inputFormat);
		LocalDateTime gmtTime = LocalDateTime.parse(gmtTimeStr, inputFormat);
		LocalDateTime bstTime = LocalDateTime.parse(bstTimeStr, inputFormat);
		LocalDateTime cstTime = LocalDateTime.parse(cstTimeStr, inputFormat);
		
		// Assigning values to p5 array
		p5[0] = astTime;
		p5[1] = cstTime;
		p5[2] = gmtTime;
		p5[3] = bstTime;
		p5[4] = zstTime;
		
		// Sorting array
		Arrays.sort(p5, Collections.reverseOrder());
		
		// Loop through array to print contents
		for(int i = 0; i < p5.length; i++) {
			System.out.println(p5[i]);
		}
	}
// end 
}