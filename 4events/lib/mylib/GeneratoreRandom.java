package lib.mylib;
import java.util.Random;

/**
 * Classe di utilità per la formattazione delle stringhe
 */

public class GeneratoreRandom 
{

	private static Random rand = new Random();
/**Metodo per l'estrazione degli interi
 * 
 * @param min	Valore minimo del range
 * @param max	Valore massimo del range
 * @return		Valore casuale nel range
 */
	public static int estraiIntero(int min, int max)
	{
		int range = max + 1 - min;
		int casuale = rand.nextInt(range);
		return casuale + min;
	}
/**Metodo per l'estrazione di variabili double
 * 
 * @param min	Valore minimo del range
 * @param max	Valore massimo del range
 * @return		Valore casuale nel range
 */
	public static double estraiDouble(double min, double max)
	{
		double range = max + 1 - min;
		double casuale = rand.nextDouble()*range;
		return casuale + min;
	}

}
