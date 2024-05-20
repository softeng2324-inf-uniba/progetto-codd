package it.uniba.app;
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
        System.out.println("Elenco dei comandi:\n/gioca\n/esci\n/qualimosse\n/abbandona\n/tavoliere\n/vuoto");
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
        System.out.print("giocatore " + g + " inserisci il tuo nome: ");
    }
    /**
     * Metodo che stampa richiesta di inserimento del comando.
     */
    public static void stampaInserireComando() {
        System.out.print("inserire comando: ");
    }
    public static void stampaErroreComando() {
        System.out.println("comando non esistente");
    }
}
