package perceptron;

//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;

public class Perceptron
{
	
	Node node;
	Connection connection[];

	private static double learningRate = 0.1;
	
	/**
	 * Überladener Konstruktor.
	 * @param input
	 */
	public Perceptron(int input)
	{
		connection = new Connection[input + 1];
		for (int i = 0; i < connection.length; i++)
		{
			connection[i] = new Connection(0);
		}
		connection[connection.length - 1] = new Connection(1);
		node = new Node(connection);
	}
	
	/**
	 * Trainiert den erwartungswert.
	 * @param switches
	 * @param outcome
	 */
	public void training(int[][] switches, int[] outcome)
	{
		boolean pruefe = false;
		do
		{
			pruefe = false;
			for (int i = 0; i < switches.length; i++)
			{
				int[] current = switches[i];
				for (int j = 0; j < current.length; j++)
				{
					connection[j].setValue(current[j]);
				}
				double out = node.getOutput();
				if (out != outcome[i])
				{
					double error = Utility.calculateError(out, outcome[i]);
					pruefe = true;
					for (Connection c : connection)
					{
						c.lernen(error, learningRate);
					}
				}
			}
		} while (pruefe);
	}
}
