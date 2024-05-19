package it.uniba.app;
import java.util.Scanner;
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

}
