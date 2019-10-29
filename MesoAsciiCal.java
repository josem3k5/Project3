// Generated
public class MesoAsciiCal extends MesoAsciiAbstract 
{
	// String representing what station name the user picks, used to connect to MesoStation class
	private MesoStation toMeso;

	// The average value of the station being passed in by the input
	public static int totalAvg;

	// The station NRMN to use to find the ASCII average
	private int nrmnStation = 79;

	// Double representing how many chars there are for every station in the Mesonet.txt file
	private double stationLength = 4.0;

	// Constructor
	public MesoAsciiCal(MesoStation mesoStation) {
		this.toMeso = mesoStation;

	}

	@Override
	int calAverage() {

		// Number to divide the ASCII station name that the user passes in
		int division = 4;
		
		// Starting ascii value
		int asciiValue = 0;
		
		// Double representing the total ASCII value for userStation
		double charValueTotal = 0;

		// User station that was passed in by user being accessed by method
		String userStation = toMeso.getStID();

		// Array used to store in ASCII value for selected station
		Double[] array = new Double[4];
		
		// Double representing the ascii value for selected station
		double asciiAvg = 0.0;
		
		// Go through station name to calculate the ASCII value
		for(int i = 0; i < 4; i++) {

			array[i] = (double) userStation.charAt(i);
		}
		
		// Calculating the ASCII value for selected station
		asciiAvg = (array[0] + array[1] + array[2] + array[3]) / stationLength;
		
		// Round the ascii value
		asciiValue = (int) Math.round(asciiAvg);
		
		// Calculate the average of the two averages (current selected station and NRMN station)
		int anotherAverage = (int) Math.round((asciiValue + nrmnStation) / 2);
		
		// store total average into totalAvg variable to be used by other class
		totalAvg = anotherAverage;
		
		return anotherAverage;
	}
}

// end