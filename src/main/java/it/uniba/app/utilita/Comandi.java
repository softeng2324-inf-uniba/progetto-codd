package it.uniba.app.utilita;
import it.uniba.app.campodagioco.Tavoliere;
import it.uniba.app.utente.Giocatore;

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
            return 0;
        }
        return 1;
    }
    /**
     * Metodo che gestisce il comando /esci.
     * @return true se il giocatore vuole uscire dall' applicazione.
     */
    public static boolean comandoEsci() {
        Stampe.stampaSicuroDiUscire();
        String scelta = Tastiera.readString();
        return !("1".equals(scelta));
    }

    /**
     * Metodo che gestisce il comando /abbandona.
     * @param partitaIniziata booleano che indica se c'è una partita in corso.
     * @param tav tavoliere.
     * @param g giocatore in gioco.
     * @return false se il giocatore finisce la partita.
     */
    public static boolean comandoAbbandona(final boolean partitaIniziata,
                                           final Tavoliere tav, final Giocatore g, final int turnoGiocatore) {
        if (partitaIniziata) {
            Stampe.stampaSicuroDiAbbandonare();
            String scelta = Tastiera.readString();
            if ("1".equals(scelta)) {
                Stampe.stampaPartitaAbbandonata(g,  tav.getPedine(altroGiocatore(turnoGiocatore)));
                return false;
            } else {
                Stampe.stampaErroreAbbandono2();
            }
        } else {
            Stampe.stampaErroreAbbandono();
        }
        return partitaIniziata;
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
