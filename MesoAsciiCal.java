// Generated
public class MesoAsciiCal extends MesoAsciiAbstract 
{
	// String representing what station name the user picks, used to connect to MesoStation class
	private MesoStation toMeso;

	// The average value of the station being passed in by the input
	public static int totalAvg;

	// The station NRMN to use to find the ASCII average
	private int nrmnStation = 79;

	private double stationLength = 4.0;

	// Constructor
	public MesoAsciiCal(MesoStation mesoStation) {
		this.toMeso = mesoStation;

	}

	@Override
	int calAverage() {

		// Number to divide the ASCII station name that the user passes in
		int division = 4;
		int asciiValue = 0;
		// Double representing the total ASCII value for userStation
		double charValueTotal = 0;

		// User station that was passed in by user being accessed by method
		String userStation = toMeso.getStID();

		Double[] array = new Double[4];
		
		double asciiAvg = 0.0;
		
		// Go through station name to calculate the ASCII value
		for(int i = 0; i < 4; i++) {

			array[i] = (double) userStation.charAt(i);
		}
		
		// Calculating the ASCII value for selected station
		asciiAvg = (array[0] + array[1] + array[2] + array[3]) / stationLength;
		
		asciiValue = (int) Math.round(asciiAvg);
		
		int anotherAverage = (int) Math.round((asciiValue + nrmnStation) / 2);
		
		totalAvg = anotherAverage;
		
		return anotherAverage;
	}
}

// end