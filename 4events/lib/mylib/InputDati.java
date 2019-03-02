package lib.mylib;


import java.util.Random;
import java.util.Scanner;
/**
 * Classe di utilità per l'input dei dati
 */
public class InputDati
{

	// strumenti
	private static Scanner in = new Scanner(System.in);
	private static Random random = new Random();

	// costanti
	private final static String ERRORE_FORMATO = "Attenzione: il dato inserito non è nel formato corretto";
	private final static String ERRORE_MINIMO = "Attenzione: è richiesto un valore maggiore o uguale a ";
	private final static String ERRORE_STRINGA_VUOTA = "Attenzione: non hai inserito alcun carattere";
	private final static String ERRORE_OOB = "Attenzione: il valore è minore o maggiore dei valori richiesti";
	
	// deprecated
	// private final static String ERRORE_MASSIMO = "Attenzione: è richiesto un valore minore o uguale a ";;
	// private final static String MESSAGGIO_AMMISSIBILI = "Attenzione: i caratteri ammissibili sono: ";

	/**
	 * Metodo per leggere stringhe da console
	 * @param messaggio 			frase preposta all'input
	 * @return 						stringa
	 */
	
	
	public static String leggiStringa(String messaggio)
	{
		System.out.print(messaggio);
		return in.nextLine();
	}

	/**
	 * Metodo per la lettura di stringhe non vuote
	 * @param messaggio 			frase preposta all'input
	 * @return 						stringa trimmata
	 */
	
	
	public static String leggiStringaNonVuota(String messaggio)
	{
		boolean finito = false;
		String lettura = null;
		do
		{
			lettura = leggiStringa(messaggio);
			lettura = lettura.trim();
			if (lettura.length() > 0)
				finito = true;
			else
				System.out.println(ERRORE_STRINGA_VUOTA);
		} while (!finito);

		return lettura;
	}

	
	
	
	/**
	 * Acquisisce un carattere
	 * 
	 * @param messaggio				frase preposta all'input
	 * @return 						char
	 */
	public static char leggiChar(String messaggio)
	{
		while (true)
		{
			System.out.print(messaggio);
			String input = in.nextLine();
			if (input.length() > 0)
			{
				return input.charAt(0);
			} else
			{
				System.out.println(ERRORE_STRINGA_VUOTA);
			}
		}
	}

	
	

	/**
	 * Acquisisce un valore intero
	 * 
	 * @param messaggio				frase preposta all'input
	 * @return int
	 */
	
	public static int leggiIntero(String messaggio)
	{
		boolean validInput;
		int newNumber = 0;
		do
		{
			System.out.print(messaggio);
			try
			{
				validInput = true;
				newNumber = Integer.parseInt(in.nextLine());
			} catch (NumberFormatException exception)
			{
				validInput = false;
				System.out.println(ERRORE_FORMATO);
			}
		} while (!validInput);
		return newNumber;
	}


	/**
	 * Acquisisce un intero maggiore di un minimo (incluso)
	 *
	 * @param min 			valore minimo
	 * @return 				int
	 */
	
	
	public static int leggiIntero(String messaggio, int min)
	{
		int i = leggiIntero(messaggio);
		while (i < min)
		{
			System.out.println(ERRORE_OOB);
			i = leggiIntero(messaggio);
		}
		return i;
	}

	/**
	 * Acquisisce un intero compreso tra due estremi (inclusi)
	 *
	 * @param min 								valore estremo minimo
	 * @param max 								valore estremo massimo
	 * @throws IllegalArgumentException 		Se l'estremo inferiore è maggiore del superiore
	 * @return 									int
	 */
	
	public static int leggiIntero(String messaggio, int min, int max) throws IllegalArgumentException
	{
		if (min > max) throw new IllegalArgumentException("Min non può essere maggiore di max");
		int i = leggiIntero(messaggio);
		while (i < min || i > max)
		{
			System.out.println(ERRORE_OOB);
			i = leggiIntero(messaggio);
		}
		return i;
	}
	/**
	 * Metodo per la lettura di un valore double 
	 * @param messaggio 		frase preposta all'input 
	 * @return valore 			richiesto in double
	 */

	public static double leggiDouble(String messaggio)
	{
		boolean validInput;
		double newNumber = 0;
		do
		{
			System.out.print(messaggio);
			try
			{
				validInput = true;
				newNumber = Double.parseDouble(in.nextLine());
			} catch (NumberFormatException exception)
			{
				validInput = false;
				System.out.println(ERRORE_FORMATO);
			}
		} while (!validInput);
		return newNumber;
	}
	
	/**Metodo per la lettura di un valore double avendo un minimo
	 * 
	 * @param messaggio 		frase preposta all'input 
	 * @param minimo 			valore minimo inseribile
	 * @return valore 			double richiesto
	 */
	
	
	public static double leggiDoubleConMinimo(String messaggio, double minimo)
	{
		boolean finito = false;
		double newNumber = 0;
		do
		{
			newNumber = leggiDouble(messaggio);
			if (newNumber >= minimo)
				finito = true;
			else
				System.out.println(ERRORE_MINIMO + minimo);
		} while (!finito);

		return newNumber;
	}

	/**
	 * Chiede all'utente di rispondere ad una scelta tra due opzioni
	 * 
	 * @param _messaggio 			frase preposta all'input 
	 * @param _primaOpzione
	 * @param _secondaOpzione
	 * @return 						boolean
	 */
	public static boolean choice(String _messaggio, char _primaOpzione, char _secondaOpzione)
	{
		_messaggio = _messaggio + " (" + _primaOpzione + "/" + _secondaOpzione + "): ";
		char decisione = leggiChar(_messaggio);
		while (true)
		{
			if (decisione == _primaOpzione || decisione == Character.toUpperCase(_primaOpzione))
			{
				return true;
			} else if (decisione == _secondaOpzione || decisione == Character.toUpperCase(_secondaOpzione))
			{
				return false;
			} else
			{
				System.out.print(ERRORE_FORMATO);
				decisione = leggiChar(_messaggio);
			}
		}
	}


	/**
	 * Ritorna un int casuale compreso tra min (incluso) e max (escluso)
	 *
	 * @param min 							estremo inferiore
	 * @param max 							estremo superiore
	 * @return 								int numero casuale estratto
	 * @throws IllegalArgumentException 	Se l'estremo inferiore è maggiore del superiore
	 */
	public static int randomInt(int min, int max) throws IllegalArgumentException
	{
		if (min > max) throw new IllegalArgumentException("Min non può essere maggiore di max");
		return min + random.nextInt(max-min);
	}


	/**
	 * Ritorna un double casuale compreso tra 0 (incluso) e 1 (escluso)
	 *
	 * @return 			double
	 */
	public static double randomDouble()
	{
		return random.nextDouble();
	}

	
	/**
	 * Chiude lo scanner aperto in mylib
	 */
	public static void chiudiScan()
	{
		in.close();
	}
}
