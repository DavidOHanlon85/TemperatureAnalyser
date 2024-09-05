/**
 * 
 */
package p1;

/**
 * 
 */
public class DaithíÓhAnluain15621049 {

	/**
	 * Daithí Ó hAnluain - 15621049
	 * 
	 * @param args
	 */

	// Use of constant for historic average
	public static final double HISTORIC_AVERAGE = 8.4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] temperatures = { { 4, 6, 8 }, { 10, 8 }, { 5, 9, 12, 13, 3 }, { 5, 6, 3, 19 }, { 8, 19, 18 },
				{ 2, 6, 8, 10 }, { 3, 6, 20, 4 } };

		// Title

		printTemperatureAnalyserTitle();
		System.out.println();

		// Readings displayed

		printFormatted2DArrayToTheConsole(temperatures);

		// Number of samples

		System.out.println();

		int Samples = totalNumberOfSamples(temperatures);
		System.out.println("Number of samples\t: " + Samples);

		// Highest temp

		int currentMax = highestTemperature(temperatures);

		System.out.println("Highest temp\t\t: " + currentMax);

		// Lowest temp

		int currentMin = lowestTemperature(temperatures);

		System.out.println("Lowest temp\t\t: " + currentMin);

		// Average Temperature

		double average = averageTemperature(temperatures);

		System.out.printf("Average temperature\t: %.2f", average);

		// Compared to Average

		System.out.println();

		System.out.println();

		dailyComparisionToHistoricAverage(temperatures);

		System.out.println();
		conclusionOfReport();

	}

	/**
	 * This method prints the concluding line to the console
	 */
	public static void conclusionOfReport() {
		System.out.println("____________________________");
	}

	/**
	 * This method prints a table which compares each daily average to the historic
	 * average and prints coloured indication arrows based on the project specification provided
	 * 
	 * @param temperatures
	 */
	public static void dailyComparisionToHistoricAverage(int[][] temperatures) {
		int dailyTotal = 0;
		int numberOfSamplesPerDay = 0;
		double dailyAverage = 0;

		System.out.println("Day\tOverall Average (Compared to historic average 8.4)");
		for (int i = 0; i < temperatures.length; i++) {
			System.out.print((i + 1) + "\t");
			for (int j = 0; j < temperatures[i].length; j++) {
				dailyTotal += temperatures[i][j];
				numberOfSamplesPerDay++;
				dailyAverage = (double) dailyTotal / numberOfSamplesPerDay;
			}

			printToRequiredDegreeOfAccuracy(dailyAverage, i);

			arrowAndColouredPrinting(dailyAverage);

			dailyTotal = 0;
			numberOfSamplesPerDay = 0;
			dailyAverage = 0;
		}
	}

	/**
	 * This method prints the required arrows in the required colours to the console
	 * based on it's average compared to the historic average
	 * 
	 * @param dailyAverage
	 */
	public static void arrowAndColouredPrinting(double dailyAverage) {
		if (dailyAverage >= HISTORIC_AVERAGE + 5) {
			System.out.print("\033[0;31m");
			System.out.print("\u21C8");
			System.out.print("\033[0;30m");
			System.out.print("");
			System.out.println();
		} else if (dailyAverage > HISTORIC_AVERAGE) {
			System.out.print("\033[0;31m");
			System.out.print("\u2191");
			System.out.print("\033[0;30m");
			System.out.println();
		} else if (dailyAverage < HISTORIC_AVERAGE) {
			System.out.print("\u2193");
			System.out.println();
		} else {
			System.out.print("\u2194");
			System.out.println();
		}
	}

	/**
	 * This method prints the overall outcomes to the required degree of accuracy as
	 * described in the project specification
	 * 
	 * @param dailyAverage
	 * @param i
	 */
	public static void printToRequiredDegreeOfAccuracy(double dailyAverage, int i) {
		if (i == 0 || i == 1 || i == 2 || i == 4 || i == 5) {
			System.out.printf("(%.1f)\t", dailyAverage);
		} else {
			System.out.printf("(%.2f)\t", dailyAverage);
		}
	}

	/**
	 * This method calculates the total of all temperatures in the 2D Array as well
	 * as the total number of readings and uses these two integers to calculate the
	 * average - cast to double used
	 * 
	 * @param temperatures
	 * @return
	 */
	public static double averageTemperature(int[][] temperatures) {
		int total = 0;
		int numberOfReadings = 0;
		double average = 0;

		for (int i = 0; i < temperatures.length; i++) {
			for (int j = 0; j < temperatures[i].length; j++) {
				total += temperatures[i][j];
				numberOfReadings++;
			}
		}

		average = (double) total / numberOfReadings;
		return average;
	}

	/**
	 * This method calculates and returns the lowest temperature in the 2D Array
	 * 
	 * @param temperatures - Input 2D Array
	 * @return - currentMin - Lowest Temperature in 2D Array
	 */
	public static int lowestTemperature(int[][] temperatures) {
		int currentMin = temperatures[0][0];

		for (int i = 0; i < temperatures.length; i++) {
			for (int j = 0; j < temperatures[i].length; j++) {
				if (currentMin > temperatures[i][j]) {
					currentMin = temperatures[i][j];
				}
			}
		}
		return currentMin;
	}

	/**
	 * This method calculates and returns the highest temperature in the 2D Array
	 * 
	 * @param temperatures - Input 2D Array
	 * @return - currentMax - Highest Temperature in 2D Array
	 */
	public static int highestTemperature(int[][] temperatures) {
		int currentMax = temperatures[0][0];

		for (int i = 0; i < temperatures.length; i++) {
			for (int j = 0; j < temperatures[i].length; j++) {
				if (currentMax < temperatures[i][j]) {
					currentMax = temperatures[i][j];
				}
			}
		}
		return currentMax;
	}

	/**
	 * This method calculates the total number of samples in the 2D Array and
	 * returns this as an integer
	 * 
	 * @param temperatures - Input 2D Array
	 * @return - numberOfSamples - integer representing the total number of samples
	 */
	public static int totalNumberOfSamples(int[][] temperatures) {
		int numberOfSamples = 0;

		for (int i = 0; i < temperatures.length; i++) {
			for (int j = 0; j < temperatures[i].length; j++) {
				numberOfSamples++;
			}
		}
		return numberOfSamples;
	}

	/**
	 * This method prints a formatted 2DArray to the console. It displays all
	 * readings per day for each day.
	 * 
	 * @param temperatures
	 */
	public static void printFormatted2DArrayToTheConsole(int[][] temperatures) {
		System.out.println("All readings per day");
		System.out.println("Day\tReadings");
		for (int i = 0; i < temperatures.length; i++) {
			System.out.print((i + 1) + "\t");
			for (int j = 0; j < temperatures[i].length; j++) {
				System.out.print(temperatures[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * This method prints the Temperature Analyser Title to the console
	 */
	public static void printTemperatureAnalyserTitle() {
		System.out.println("Temperature analyser program\n____________________________");
	}

}
