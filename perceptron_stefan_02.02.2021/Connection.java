package perceptron;

import java.util.Random;

public class Connection
{
	/**
	 * Überladener Konstruktor
	 * @param value
	 */
	public Connection(int value)
	{
		this.value = value;
		weight = (int)(Math.random());
	}

	Random zufall = new Random();
	private int value = 0;
	private float weight;
	private float output;
	
	/**
	 * Gibt den Output.
	 * @return output
	 */
	public float getOutput()
	{
		output = weight * value;
		return output;
	}
	
	/**
	 * Setzt Value.
	 * @param value
	 */
	public void setValue(int value)
	{
		this.value = value;
	}
	
	/**
	 * Berechner das neue Gewicht.
	 * @param error
	 * @param learningRate
	 */
	public void lernen(double error, double learningRate)
	{
		weight = (float) (weight + (value * error * learningRate));
	}
}
