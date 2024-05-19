package it.uniba.app;
/**
 * <<CONTROL>>.
 * Classe che contiene comandi
 */
public final class Comandi {
    /**
     * Costruttore.
     */
    private Comandi() {
        throw new UnsupportedOperationException("Questa è una classe di utilità e non può essere istanziata.");
    }
    /**
     * Metodo che restituisce l'altro giocatore.
     * @param giocatore numero del giocatore in gioco
     * @return numero giocatore opposto a quello in input
     */
    public static int altroGiocatore(final int giocatore) {
        if (giocatore == 1) {
            return 2;
        }
        return 1;
    }

}
