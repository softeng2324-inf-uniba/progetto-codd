package it.uniba.app;
import java.util.Set;

/**
 * Classe main dell'app.
 */
public final class App {

    /**
     * Metodo che stampa un saluto.
     * @return "Benvenuto in Ataxx"
     */
    public String getGreeting() {
        return "\u001B[38;5;201m\u001B[1mBenvenuto in Ataxx\u001B[0m";
    }
    /**
     * Metodo che permette all'utente di inserire il nome giocatore.
     * @param g numero del giocatore.
     * @return Giocatore con nome impostato.
     */
    public static Giocatore setNome(final int g) {
        Stampe.stampaRichiestaInserimentoNome(g);
        String nomeGiocatore = Tastiera.readString();
        return new Giocatore(nomeGiocatore);
    }

    /**
     * Entrypoint of the application.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        System.out.println(new App().getGreeting());
        System.out.println("digita \u001B[1m/help\u001B[0m");
        Set<String> comandiAiuto = Set.of("/help", "-h", "--help");
        Set<String> comandi = Set.of("/esci","/gioca","/abbandona","/tavoliere","/qualimosse","/vuoto");
        boolean loop = true;
        boolean partitaIniziata = false;
        int turno = 1;
        Tavoliere tav = null;
        Giocatore[] giocatori = new Giocatore[2];
        while (loop) {
            Stampe.stampaInserireComando();
            String comando = Tastiera.readString();
            if (comando != null) {
                if (comandiAiuto.contains(comando)) {
                    Stampe.stampaComandi();
                }
                if ("/esci".equals(comando)) {
                    loop = Comandi.comandoEsci();
                }
                if ("/gioca".equals(comando)) {
                    if (!partitaIniziata) {
                        tav = Tavoliere.inizializzaTavoliere(new Tavoliere());
                        giocatori[0] = setNome(1);
                        giocatori[1] = setNome(2);
                        System.out.println(tav);
                        partitaIniziata = true;
                    } else {
                        Stampe.stampaPartitaGiaInCorso();
                    }
                }
                if ("/abbandona".equals(comando)) {
                    partitaIniziata = Comandi.comandoAbbandona(partitaIniziata, tav, giocatori[turno], turno);
                }
                if ("/tavoliere".equals(comando)) {
                    Comandi.comandoTavoliere(partitaIniziata, tav);
                }
                if ("/qualimosse".equals(comando)) {
                    Comandi.comandoQualiMosse(partitaIniziata, tav, turno);
                }
                if ("/vuoto".equals(comando)) {
                    System.out.println(Tavoliere.stampaTabelloneVuoto());
                }
                if (!comandi.contains(comando) && !comandiAiuto.contains(comando)){
                    Stampe.stampaErroreComando();
                }
            }
        }
    }
}
