package lib.mylib;
/**
 * Classe di utilità per la creazione di un menu
 */
public class MyMenu
{
	private static final String BENVENUTO = "Benvenuto al menù";
	private static final String ANNULLA = "\n0 - Esci dal programma";
	private static final String INSERIRE_SCELTA = "Inserire la scelta desiderata: ";

	/**
	 * Mostra il messaggio di benvenuto
	 */
	
	
	public static void benvenuto()
	{
		System.out.println(BENVENUTO);
	}

	
	/**
	 * Metodo per consentire di mostrare opzioni in un menu
	 * @param args			stringhe per scelta multipla come argomenti
	 * @return				int passato dalla funzione leggIntero nel range
	 */
	
	public static int displayOptions(String... args)
	{
		System.out.println(ANNULLA);
		int i = 1;
		
		for (String item : args)
		{
			System.out.printf("%d - %s%n", i, item);
			i++;
		}
		
		return InputDati.leggiIntero(INSERIRE_SCELTA, 0, i);
	}
}

