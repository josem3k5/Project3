import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

// Generated
public class MesoEquivalent {
	
	// Hashmap that will hold all station names from Mesonet.txt
	private HashMap<String, Integer> stationsMap = new HashMap<String, Integer>();
	
	private HashMap<String, Integer> stationsAndValueMap = new HashMap<String, Integer>();
	
	// String representing the station being passed in by the user
	private String station;
	
	// Current station in the hash map
	private String currStation;
	
	// Int representing the total ascii value for each station of the hashmap
	private int ascii;
	
	// Average value from MesoAsciiCal class
	int totalAvg = MesoAsciiCal.totalAvg;
	
	// Constructor
	public MesoEquivalent(String stId) throws IOException {
		this.station = stId;
		
		// Read file with bufferReader
		BufferedReader br = new BufferedReader(new FileReader("Mesonet.txt"));

		// String representing current line being read by bufferedReader
		String currLine;

		// Skip first 3 lines that contain no important information to us
		currLine = br.readLine();
		currLine = br.readLine();
		currLine = br.readLine();
				
		// Begin to read every line where information starts (line 7) as long as line != null
		while((currLine = br.readLine()) != null) {

			// Start of substring for STID station name
			int startChar = 0;

			// End of substring for STID station name
			int endChar = 4;

			// Trim out white space of current line
			String stationTrimmed = currLine.trim();

			currStation = stationTrimmed.substring(startChar, endChar);

			// Adding each station name to ArrayList, STIDnames
			stationsMap.put(currStation, null);
		}
		// Close br
		br.close();
	}
	
	// Method that reads in Mesonet.txt and calculates the average ASCII value
	public HashMap<String, Integer> calAsciiEqual(){

		// Calculate the ASCII value for every station in the hashmap
		for (Entry <String, Integer> key : stationsMap.entrySet()) {
			
			// Number to divide the ASCII station name that the user passes in
			int division = 4;

			// Int representing the total ASCII value for station
			double charValueTotal = 0;

			// Go through station name to calculate the ASCII value
			for(int i = 0; i < currStation.length(); i++) {

				// Grab the current char of station
				char currentChar = key.getKey().charAt(i);

				// Converting the current char to an int
				int asciiValue = (int) currentChar;

				// Getting the total ASCII value for the station name
				charValueTotal = charValueTotal + asciiValue;
			}
			
			// Calculate the average value for the station name
			double tempAvg = (charValueTotal / division);

			// Assigning the value after correctly rounding up or down to newAvg
			ascii = (int) Math.round(tempAvg);
			
			// Checking if the current station's ASCII value is the same as the average ASCII value calculated from MesoAsciiCal
			if(ascii == totalAvg) {
				
				stationsAndValueMap.put(key.getKey(), ascii);
			}
		}
		return stationsAndValueMap;
	}
	// end
}