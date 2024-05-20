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


    /**
     * Metodo che gestisce il comando Tavoliere.
     * @param partitaIniziata booleano che indica se c'è una partita in corso.
     * @param tav tavoliere.
     */
    public static void comandoTavoliere(final boolean partitaIniziata, final Tavoliere tav) {
        if (!partitaIniziata) {
            Stampe.stampaConsigliaGioca();
        } else {
            System.out.println(tav.toString());
        }
    }

    /**
     * Metodo che gestisce il comando qualimosse.
     * @param partitaIniziata booleano che indica se c'è una partita in corso.
     * @param tav tavoliere.
     * @param turnoGiocatore indica il giocatore in gioco.
     */
    public static void comandoQualiMosse(final boolean partitaIniziata, final Tavoliere tav, final int turnoGiocatore) {
        if (!partitaIniziata) {
            Stampe.stampaConsigliaGioca();
        } else {
            tav.qualiMosse(turnoGiocatore);
        }
    }
}
