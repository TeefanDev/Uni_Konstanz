package perceptron;

public class Node
{
	/**
	 * Überladener Konstruktor
	 * @param array
	 */
	public Node(Connection[] array)
	{
		connection = array;
	}

	Utility utility = new Utility();
	Connection[] connection;
	
	/**
	 * Berechnet die Summe und gibt aus, ob sie größer als 0,5 ist oder nicht.
	 * @return 0 oder 1
	 */
	public double getOutput()
	{
		double sum = 0;
		for (int i = 0; i < connection.length; i++)
		{
			sum += connection[i].getOutput();
		}
		return Utility.stepFunktion(sum);
	}

}
