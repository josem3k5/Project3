// Generated
public class MesoAsciiCal extends MesoAsciiAbstract 
{
	// String representing what station name the user picks, used to connect to MesoStation class
	private MesoStation toMeso;
	
	// The average value of the station being passed in by the input
	public static int newAvg;
	
	// Constructor
	public MesoAsciiCal(MesoStation mesoStation) {
		this.toMeso = mesoStation;
	}

	@Override
	int calAverage() {
		
		// Number to divide the ASCII station name that the user passes in
		int division = 4;

		// Int representing the total ASCII value for userStation
		double charValueTotal = 0;

		// User station that was passed in by user being accessed by method
		String userStation = toMeso.getStID();

		// Go through station name to calculate the ASCII value
		for(int i = 0; i < userStation.length(); i++) {

			// Grab the current char of userStation
			char currentChar = userStation.charAt(i);

			// Converting the current char to an int
			int asciiValue = (int) currentChar;

			// Getting the total ASCII value for the station name
			charValueTotal = charValueTotal + asciiValue;
		}
		
		// Calculate the average value for the station name
		double tempAvg = (charValueTotal / division);

		// Assigning the value after correctly rounding up or down to newAvg
		newAvg = (int) Math.round(tempAvg);

		return newAvg;
	}
// end
}