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
     * Metodo che stampa richiesta di inserimento del comando.
     */
    public static void stampaInserireComando() {
        System.out.print("inserire comando: ");
    }
    /**
     * Metodo che stampa messaggio errore input
     */
    public static void stampaErrore() {
        System.out.println("Il comando inserito non esiste ");
    }
}
