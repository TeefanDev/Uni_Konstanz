package perceptron;

public class Utility
{
	public Utility()
	{}
	
	static GUI gui;
	
	public static void main(String[] args)
	{		
		Perceptron perceptron = new Perceptron(2);
		//double a = (double) (Math.random() * 1);
		//double b = (double) (Math.random() * 1);
		//double prediction = 0.0;
		//double label = 0.0;

		int[][] statesOfSwitches = new int[][]{{0, 0},{0, 1}, {1, 0}, {1, 1}};
		int[] outcomeLogicAND = new int[4];
		int[] outcomeLogicOR = new int[4];
		int[] outcomeLogicNOR = new int[4];
		int[] outcomeLogicNAND = new int[4];
		int[] outcomeLogicXOR = new int[4];

		//statesOfSwitches[0][0] = 0;
		//statesOfSwitches[0][1] = 0;
		//statesOfSwitches[0][2] = 1;
		//statesOfSwitches[0][3] = 1;
		//statesOfSwitches[1][0] = 0;
		//statesOfSwitches[1][1] = 1;
		//statesOfSwitches[1][2] = 0;
		//statesOfSwitches[1][3] = 1;

		// AND
		outcomeLogicAND[0] = 0;
		outcomeLogicAND[1] = 0;
		outcomeLogicAND[2] = 0;
		outcomeLogicAND[3] = 1;

		// OR
		outcomeLogicOR[0] = 0;
		outcomeLogicOR[1] = 1;
		outcomeLogicOR[2] = 1;
		outcomeLogicOR[3] = 1;

		// NOR
		outcomeLogicNOR[0] = 1;
		outcomeLogicNOR[1] = 0;
		outcomeLogicNOR[2] = 0;
		outcomeLogicNOR[3] = 0;

		// NAND
		outcomeLogicNAND[0] = 1;
		outcomeLogicNAND[1] = 1;
		outcomeLogicNAND[2] = 1;
		outcomeLogicNAND[3] = 0;

		// XOR
		outcomeLogicXOR[0] = 0;
		outcomeLogicXOR[1] = 1;
		outcomeLogicXOR[2] = 1;
		outcomeLogicXOR[3] = 0;
		
		perceptron.training(statesOfSwitches, outcomeLogicAND);
		
		gui = new GUI();
		gui.begin();
		
	}
	
	/**
	 * Schaut, ob 2 double werte gleich sind oder nicht.
	 * @param a
	 * @param b
	 * @return true or false
	 */
	public static boolean doubleComparison(double a, double b)
	{
		boolean equal;
		double delta = 0.000001;
		equal = (Math.abs((a - b)) < delta);
		if (equal == true)
		{
			return true;
		} 
		else
		{
			double prediction = a;
			double label = b;
			double errorValue = calculateError(prediction, label);
			System.out.println("Error Value = " + errorValue);
			return false;
		}
	}
	
	/**
	 * Berechnet den Error.
	 * @param prediction
	 * @param label
	 * @return 0 oder prediction - label
	 */
	public static double calculateError(double prediction, double label)
	{
		boolean equal;
		double delta = 0.000001;
		equal = (Math.abs((prediction - label)) < delta);
		System.out.println("Prediction = " + prediction);
		System.out.println("Label = " + label);
		if (equal == true)
		{
			return (0.0);
		} else
		{
			return (Math.abs(prediction - label));
		}
	}
	
	/**
	 * Überprüft, ob die summe größer als 0,5 ist.
	 * @param sum
	 * @return 0 oder 1
	 */
	public static double stepFunktion(double sum)
	{
		if (sum > 0.5)
		{
			System.out.println("sum = " + sum + ": Error -> 1.0");
			return (1);
		} 
		else
		{
			System.out.println("sum = " + sum + ": Error -> 0.0");
			return (0);
		}
	}
}
