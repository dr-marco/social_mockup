package lib.mylib;
/**
 * Classe di utilità per la formattazione delle stringhe
 */
public class BelleStringhe
{

	private final static String SPAZIO = " ";
	private final static String CORNICE = "---------------------------------------------------";
	private final static String ACAPO = "\n";

/**Metodo per incorniciare stringhe
 * 
 * @param s stringa da incorniciare
 * @return stringa incorniciata
 */
	public static String incornicia(String s)
	{
		StringBuffer res = new StringBuffer();

		res.append(CORNICE + ACAPO);
		res.append(s + ACAPO);
		res.append(CORNICE + ACAPO);

		return res.toString();

	}
/**Metodo per l'incolonnazione dei metodi
 * 
 * @param s stringa da incolonnare
 * @param larghezza larghezza a cui si vuole incolonnare
 * @return stringa incolonnata
 */

	public static String incolonna(String s, int larghezza)
	{
		StringBuffer res = new StringBuffer(larghezza);
		int numCharDaStampare = Math.min(larghezza, s.length());
		res.append(s.substring(0, numCharDaStampare));
		for (int i = s.length() + 1; i <= larghezza; i++)
			res.append(SPAZIO);
		return res.toString();
	}
/**
 * Metodo per centrare stringhe
 * @param s stringa da centrare
 * @param larghezza larghezza a cui centrare 
 * @return stringa centrata
 */
	public static String centrata(String s, int larghezza)
	{
		StringBuffer res = new StringBuffer(larghezza);
		if (larghezza <= s.length())
			res.append(s.substring(larghezza));
		else
		{
			int spaziPrima = (larghezza - s.length()) / 2;
			int spaziDopo = larghezza - spaziPrima - s.length();
			for (int i = 1; i <= spaziPrima; i++)
				res.append(SPAZIO);

			res.append(s);

			for (int i = 1; i <= spaziDopo; i++)
				res.append(SPAZIO);
		}
		return res.toString();

	}
/**
 * Metodo per ripetere un carattere qualsiasi
 * @param elemento carattere da ripetere
 * @param larghezza numero di volte in cui ripetere il carattere
 * @return una stringa di caratteri ripetuti
 */
	public static String ripetiChar(char elemento, int larghezza)
	{
		StringBuffer result = new StringBuffer(larghezza);
		for (int i = 0; i < larghezza; i++)
		{
			result.append(elemento);
		}
		return result.toString();

	}
/**
 * Metodo per isolare frasi
 * @param daIsolare frase da isolare
 * @return frase isolata
 */
	public static String rigaIsolata(String daIsolare)
	{
		StringBuffer result = new StringBuffer();
		result.append(ACAPO);
		result.append(daIsolare);
		result.append(ACAPO);
		return result.toString();
	}

}

