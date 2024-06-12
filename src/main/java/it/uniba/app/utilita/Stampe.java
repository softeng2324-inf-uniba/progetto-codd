package it.uniba.app.utilita;
import it.uniba.app.campodagioco.Tavoliere;
import it.uniba.app.utente.Giocatore;
/**
 * <<BOUNDARY>>.
 * Classe che gestisce le stampe.
 */
public final class Stampe {
    /**
     * Costruttore.
     */
    private Stampe() {
        throw new UnsupportedOperationException("Questa è una classe di utilità e non può essere istanziata.");
    }
    /**
     * Metodo che stampa comandi disponibili.
     */
    public static void stampaComandi() {
        final String s = "\033[38;5;208m|\033[0m";
        System.out.println("\033[38;5;208mELENCO COMANDI:\033[0m\n"
        + "\033[38;5;208m+------------------------------------------------------+\033[0m\n"
        + s + " /gioca      " + s + " permette di iniziare una nuova partita " + s + "\n"
        + s + " /esci       " + s + " termina il programma                   " + s + "\n"
        + s + " /qualimosse " + s + " mostra le mosse disponibili            " + s + "\n"
        + s + " /abbandona  " + s + " comando di resa                        " + s + "\n"
        + s + " /tavoliere  " + s + " mostra il tavoliere                    " + s + "\n"
        + s + " /vuoto      " + s + " mostra il tavoliere vuoto              " + s + "\n"
        + s + " /mosse      " + s + " mostra la cronologia di mosse          " + s + "\n"
        + s + " /tempo      " + s + " mostra il tempo trascorso in partita   " + s + "\n"
        + s + " /blocca xn  " + s + " permette di bloccare una casella       " + s + "\n"
        + s + " xiyi-xjyj   " + s + " permette di muovere le pedine ex: a1-b1" + s + "\n"
        + "\033[38;5;208m+------------------------------------------------------+\033[0m\n");
    }

    /**
     * Metodo che stampa il consiglio di visualizzare l'aiuto dei comandi.
     */
    public static void stampaConsigliaAiuto() {
        System.out.println("digita \u001B[1m/help\u001B[0m");
    }

    /**
     * Metodo che stampa richiesta di conferma per uscire dall'applicazione.
     */
    public static void stampaSicuroDiUscire() {
        System.out.println("vuoi davvero uscire? Digita 1");
    }

    /**
     * Metodo che stampa richiesta di conferma per abbandonare.
     */
    public static void stampaSicuroDiAbbandonare() {
        System.out.println("Sei sicuro di abbandonare la partita? Digita 1");
    }
    /**
     * Metodo che stampa il messaggio del passaggio del turno all'avversario per mancanza di mosse disponibili.
     */
    public static void stampaPassaggioTurno() {
        System.out.println("Il giocatore non ha mosse possibili, il turno passa all'avversario");
    }
    /**
     * Metodo che stampa messaggio quando la partita è finita in pareggio.
     */
    public static void stampaPartitaPareggiata(final Tavoliere tav) {
        int pedine = tav.getPedine(0);
        System.out.println("La partita è finita in pareggio: " + pedine + " a " + pedine);
    }
    /**
     * Metodo che stampa messaggio se il giocatore decide di non abbandonare.
     */
    public static void stampaErroreAbbandono2() {
        System.out.println("La partita prosegue");
    }

    /**
     * Metodo che stampa errore nell'abbandonare la partita.
     */
    public static void stampaErroreAbbandono() {
        System.out.println("Non c'è nessuna partita in corso");
    }
    /**
     * Metodo che stampa messaggio della partita abbandonata con risultato finale.
     * @param g Giocatore.
     * @param pedine numero delle pedine del vincitore.
     */
    public static void stampaPartitaAbbandonata(final Giocatore g, final int pedine) {
        System.out.println("Hai abbandonato");
        System.out.println(g.getNome() + " ha vinto per " + pedine + " a 0");
    }

    /**
     * Metodo che stampa consiglio per iniziare la partita.
     */
    public static void stampaConsigliaGioca() {
        System.out.println("digita /gioca per iniziare nuova partita");
    }

    /**
     * Metodo che stampa consiglio se si digita /gioca con partita gia' in corso.
     */
    public static void stampaPartitaGiaInCorso() {
        System.out.println("La partita e' gia' in corso /abbandona per iniziarne un'altra");
    }

    /**
     * Metodo che stampa richiesta di inserimento nome al giocatore.
     * @param g numero del giocatore.
     */
    public static void stampaRichiestaInserimentoNome(final int g) {
        System.out.print("\u001B[94mgiocatore " + g + "\u001B[0m inserisci il tuo nome: ");
    }

    /**
     * Metodo che stampa informazione sul turno attuale.
     * @param giocatori Array dei due giocatori
     * @param turno numero del giocatore in turno
     */
    public static void stampaTurno(final Giocatore[] giocatori, final int turno) {
        System.out.println("\nTurno di " + "\u001B[94m" + giocatori[turno].getNome() + "\u001B[0m");
    }

    /**
     * Metodo che stampa richiesta di inserimento del comando.
     */
    public static void stampaInserireComando() {
        System.out.print("\u001B[1minserire comando: \u001B[0m");
    }

    /**
     * Metodo che stampa errore comando quando non esiste.
     */
    public static void stampaErroreComando() {
        System.out.println("comando non accettato");
    }
    /**
     * Metodo che stampa il messaggio alla fine della partita.
     * @param g Array di giocatori.
     * @param tav tavoliere.
     */
    public static void stampaFinePartita(final Giocatore[] g, final Tavoliere tav) {
        if (tav.getPedine(Tavoliere.PG1) + tav.getPedine(Tavoliere.PG2)
            == Tavoliere.DIM_TAV * Tavoliere.DIM_TAV) {
            System.out.println("Non ci sono più caselle disponibili");
        }
        if (tav.getPedine(Tavoliere.PG1) > tav.getPedine(Tavoliere.PG2)) {
            System.out.println(g[Tavoliere.PG1].getNome() + " ha vinto "
                + tav.getPedine(Tavoliere.PG1) + " a " + tav.getPedine(Tavoliere.PG2));
        } else {
            System.out.println(g[Tavoliere.PG2].getNome() + " ha vinto "
            + tav.getPedine(Tavoliere.PG2) + " a " + tav.getPedine(Tavoliere.PG1));
        }
    }
}
