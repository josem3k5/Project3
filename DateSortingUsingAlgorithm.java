import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

// Generating
public class DateSortingUsingAlgorithm {

	// HashMap to hold the dates of type LocalDate
	private HashMap <LocalDate, Integer> algoMap;
	
	private LocalDate unsortedTo;
	
	// Formatter to be used later in code
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	private int value;
	
	public DateSortingUsingAlgorithm() throws IOException {
		
		algoMap = new HashMap<>();
		
		// BufferedReader to read in file
		BufferedReader br = new BufferedReader(new FileReader("SortingDates.txt"));

		// String representing the current line where br is at in the file
		String currLine;

		// Assigning the current line with the br.readLine() that will read every line != null
		currLine = br.readLine();

		// Loop through each line in the file
		while(currLine != null) {

			// String representing the date
			String dateStr = "";

			// Array to store dates in
			String[] stringArray = new String[3];

			// Trimming the line for the specified value we want
			stringArray = currLine.trim().split("-");

			// Loop through the string date to trim and include "-"
			for (int i = 0; i < stringArray.length; i++) {

				// Trimming
				dateStr += stringArray[i].trim();

				// If statement to enter
				if(i < stringArray.length - 1) {
					
					// Include "-" to dateStr string for array
					dateStr += "-";
				}
			}
			// Assigning and parsing string in format
			this.unsortedTo = LocalDate.parse(dateStr);

			// Adding value to hashmap
			algoMap.put(this.unsortedTo, value);

			// Read line one more time to check if any other lines are left
			currLine = br.readLine();			
		}
		br.close();
	}
	
	// Sorting method for array in descending order
	public void dateHashMapSortedDescending() {
		
		// Iterator to help pass through local array
		int iterator = 0;
		
		// Array used to store in keys
		LocalDate[] local = new LocalDate[algoMap.size()];
		
		// Loop
		for (LocalDate key: algoMap.keySet()) {
			
			local[iterator] = key;
			
			iterator++;
		}
		
		// Loop to go through LocalDate[] local array
		for (int i = 1; i < local.length; i++) {
			
			// Store current value in entry variable of LocalDate
			LocalDate entry = local[i];
			
			// Decrement current value by 1 and store in int variable k
			int k = i -1;
			
			// While k > -1 & is before the entry, store k in local[k + 1] index
			while ((k > -1) && (local[k].isBefore(entry))) {
				
				// Storing in local index
				local[k + 1] = local[k];
				
				// Decrement k
				k--;
			}
			local[k + 1] = entry;
		}
		for (int i = 0; i < local.length; i++) {
			System.out.println(local[i]);
		}
	}

	// Sorting method for array in ascending order
	public void dateHashMapSorted() {
		
		int counter = 0;
		
		// Array that will hold
		LocalDate[] dateHolder = new LocalDate[algoMap.size()];
		
		for(LocalDate keys: algoMap.keySet()) {
			
			dateHolder[counter] = keys;
			
			// Increment the counter
			counter++;
		}
		for (int j = 1; j < dateHolder.length; j++) {
			
			LocalDate key = dateHolder[j];
			
			int i = j - 1;
			
			while ((i > -1) && (dateHolder[i].isAfter(key))) {
				
				dateHolder [i + 1] = dateHolder [i];
				
				i--;
			}
			dateHolder[i + 1] = key;
		}
		for(int i = 0; i < dateHolder.length; i++) {
			
			System.out.println(dateHolder[i]);
		}
	}
// end
}