import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

// Generating
public class DateSortingUsingAlgorithm {

	private HashMap <LocalDate, Integer> algoMap;
	private LocalDate unsortedTo;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private int value;
	
	public DateSortingUsingAlgorithm() throws IOException {
		
		algoMap = new HashMap<>();
		
		BufferedReader br = new BufferedReader(new FileReader("SortingDates.txt"));

		String currLine;

		currLine = br.readLine();

		while(currLine != null) {

			String bleh = "";

			String[] stringArray = new String[3];

			stringArray = currLine.trim().split("-");

			for (int i = 0; i < stringArray.length; i++) {

				bleh += stringArray[i].trim();

				if(i < stringArray.length - 1) {

					bleh += "-";
				}
			}
			this.unsortedTo = LocalDate.parse(bleh);

			algoMap.put(this.unsortedTo, value);

			currLine = br.readLine();			
		}
		br.close();
	}
	
	public void dateHashMapSortedDescending() {
		
		int iterator = 0;
		
		LocalDate[] local = new LocalDate[algoMap.size()];
		
		for (LocalDate key: algoMap.keySet()) {
			
			local[iterator] = key;
			
			iterator++;
		}
		
		for (int i = 1; i < local.length; i++) {
			
			LocalDate entry = local[i];
			
			int k = i -1;
			
			while ((k > -1) && (local[k].isBefore(entry))) {
				
				local[k + 1] = local[k];
				
				k--;
			}
			local[k + 1] = entry;
		}
		for (int i = 0; i < local.length; i++) {
			System.out.println(local[i]);
		}
	}

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