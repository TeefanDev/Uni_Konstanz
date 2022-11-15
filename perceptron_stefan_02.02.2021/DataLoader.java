package perceptron;

import java.io.File;
import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
import java.util.ArrayList;
//import java.util.Collections;
import java.util.Scanner;
public class DataLoader
{
	Scanner einlesen;
	File newObjekt;
	String[] zeile;
	int[][] zustand;
	int[] kennzeichen;
	ArrayList<String> zeilen = new ArrayList<String>();
	
	/**
	 * Überladener Konstruktor, der die Datei einliest und richtig ausliest.
	 * @param pfad
	 */
	public DataLoader(String pfad)
	{
		newObjekt = new File(pfad);
		try
		{
			einlesen = new Scanner(newObjekt);
			zeile = einlesen.nextLine().split(",");
			while(einlesen.hasNextLine())
			{
				zeilen.add(einlesen.nextLine());
			}
			zustand = new int[zeilen.size()][getZeile().length-1];
			for(int i = 0; i < zustand.length; i++)
			{
				for(int j = 0; j < zustand[i].length; j++)
				{
					zustand[i][j] = Integer.parseInt(zeilen.get(i).split(",")[j].replaceAll(" ", ""));
				}
			}
			kennzeichen = new int[zustand.length];
			for (int i = 0; i < zeilen.size(); i++) 
			{
					kennzeichen[i] = Integer.parseInt(zeilen.get(i).split(",")[zeile.length-1].replaceAll(" ", ""));
			}
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Geta Methode
	 * @return zeile
	 */
	public String[] getZeile()
	{
		return zeile;
	}
}
