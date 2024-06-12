package it.uniba.app.utilita;
import java.util.Scanner;

import it.uniba.app.campodagioco.Tavoliere;

import java.nio.charset.StandardCharsets;

/**
 * <<CONTROLL>>.
 */
public final class Tastiera {
    private static final Scanner SCANNER;
    private Tastiera() {
        throw new UnsupportedOperationException("Questa è una classe di utilità e non può essere istanziata.");
    }
    static {
        SCANNER = new Scanner(System.in, StandardCharsets.UTF_8);
    }

    /**
     * Legge una riga di testo da input utente.
     *
     * @return la riga di testo letta, o null se non ci sono più righe
     */
    public static String readString() {
        if (SCANNER.hasNextLine()) {
            return SCANNER.nextLine();
        } else {
            System.out.println("Nessuna riga di testo disponibile.");
            return null;
        }
    }

    /**
     * Metodo che controlla se il comando inserito per bloccare la casella è valido.
     * @param stringa input del giocatore.
     * @return true se il comando è corretto.
     */
    public static boolean bloccoValido(final String stringa) {
        final int lunghezzaStringa = 10;
        final int baseCaratteri = 36;
        final int convertiInNumero = 10;
        final int coordinataCorretta = 3;
        if (stringa.length() != lunghezzaStringa) {
            return false;
        }
        //--------------------------------------------
        // Compara prima parte del comando.
        String compara = "/blocca ";
        int i = 0;
        while (i < compara.length()) {
            if (compara.charAt(i) != stringa.charAt(i)) {
                return false;
            }
            i++;
        }
        //--------------------------------------------
        // Controlla se le coordinate sono corrette.
        int primaCoordinata = Character.digit(stringa.charAt(i), baseCaratteri) - convertiInNumero;
        int secondaCoordinata = Character.getNumericValue(stringa.charAt(i + 1)) - 1;
        if (primaCoordinata > Tavoliere.DIM_TAV || secondaCoordinata > Tavoliere.DIM_TAV
            || primaCoordinata < 0 || secondaCoordinata < 0) {
                return false;
            }
        return primaCoordinata == coordinataCorretta || secondaCoordinata == coordinataCorretta;
    }

    /**
     * Metodo che prende dalla stringa la coordinata inserita salvandola nell'array.
     * @param stringa input del giocatore.
     * @return array contenente le coordinate.
     */
    public static int[] salvaCoordinateBlocco(final String stringa) {
        final int baseCaratteri = 36;
        final int convertiInNumero = 10;
        final int lettera = 8;
        final int numero = 9;
        int[] coordinate = new int[2];
        coordinate[0] = Character.digit(stringa.charAt(lettera), baseCaratteri) - convertiInNumero;
        coordinate[1] = Character.getNumericValue(stringa.charAt(numero)) - 1;
        return coordinate;
    }

    /**
     * Metodo che controlla se la stringa inserita è corretta.
     * @param stringa input del giocatore.
     * @return true se il comando è corretto.
     */
    public static boolean inputValido(final String stringa, final boolean partitaIniziata) {
        final int charCasellaPartenza = 0;
        final int intCasellaPartenza = 1;
        final int charCasellaArrivo = 3;
        final int charSeparatore = 2;
        final int intCasellaArrivo = 4;
        final int lunghezzaStringa = 5;
        final char separatoreMossa = '-';
        if (!partitaIniziata) {
            Stampe.stampaConsigliaGioca();
        }
        if (stringa.length() != lunghezzaStringa) {
            return false;
        }
        if (stringa.charAt(charSeparatore) != separatoreMossa) {
            return false;
        }
        if (!Character.isLetter(stringa.charAt(charCasellaPartenza))
            || !Character.isLetter(stringa.charAt(charCasellaArrivo))) {
            return false;
        }
        return Character.isDigit(stringa.charAt(intCasellaPartenza))
                && Character.isDigit(stringa.charAt(intCasellaArrivo));
    }

    /**
     * Metodo che prende la stringa e salva le 2 coordinate (partenza e arrivo).
     * @param inputGiocatore stringa comando del giocatore
     * @return array con le coordinate salvate.
     */
    public static int[] separaInput(final String inputGiocatore) {
        final int baseCaratteri = 36;
        final int convertiInNumero = 10;
        final int dimensioneArray = 4;
        int[] mosse = new int[dimensioneArray];
        final int scorriStringa = 3;
        int j = 0; //posizione della stringa (posizioni da salvare: 1 1 0 1 1).
        for (int i = 0; i < mosse.length; i = i + 2) {
            mosse[i] = Character.digit(inputGiocatore.charAt(j), baseCaratteri) - convertiInNumero;
            mosse[i + 1] = Character.getNumericValue(inputGiocatore.charAt(j + 1)) - 1;
            j = j + scorriStringa;
        }
        return mosse;
    }

}
