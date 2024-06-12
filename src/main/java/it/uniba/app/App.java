package it.uniba.app;
import it.uniba.app.utente.Giocatore;
import it.uniba.app.utilita.Comandi;
import it.uniba.app.utilita.Stampe;
import it.uniba.app.utilita.Tastiera;
import it.uniba.app.campodagioco.Tavoliere;
import java.util.List;
import java.util.ArrayList;
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
        return
                """
                        \033[38;5;208m\
                        ░█████╗░ ████████╗ ░█████╗░ ██╗░░██╗ ██╗░░██╗
                        ██╔══██╗ ╚══██╔══╝ ██╔══██╗ ╚██╗██╔╝ ╚██╗██╔╝
                        ███████║ ░░░██║░░░ ███████║ ░╚███╔╝░ ░╚███╔╝░
                        ██╔══██║ ░░░██║░░░ ██╔══██║ ░██╔██╗░ ░██╔██╗░
                        ██║░░██║ ░░░██║░░░ ██║░░██║ ██╔╝╚██╗ ██╔╝╚██╗
                        ╚═╝░░╚═╝ ░░░╚═╝░░░ ╚═╝░░╚═╝ ╚═╝░░╚═╝ ╚═╝░░╚═╝\u001B[0m
                        """;
    }
    /**
     * Metodo che permette all'utente di inserire il nome giocatore.
     * @param g numero del giocatore.
     * @return Giocatore con nome impostato.
     */
    public static Giocatore setNome(final int g) {
        String nomeGiocatore;
        do {
            Stampe.stampaRichiestaInserimentoNome(g);
            nomeGiocatore = Tastiera.readString();
        } while (nomeGiocatore.length() == 0);
        return new Giocatore(nomeGiocatore);
    }

    /**
     * Entrypoint of the application.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        System.out.println(new App().getGreeting());
        Stampe.stampaConsigliaAiuto();
        Set<String> comandiAiuto = Set.of("/help", "-h", "--help");
        Set<String> comandi = Set.of("/esci", "/gioca", "/abbandona",
            "/tavoliere", "/qualimosse", "/vuoto", "/mosse", "/tempo");
        boolean loop = true;
        boolean partitaIniziata = false;
        int turno = 0;
        Tavoliere tav = new Tavoliere();
        Giocatore[] giocatori = new Giocatore[2];
        List<String> listaMosse = new ArrayList<>();
        while (loop) {
            if (partitaIniziata && tav != null) {
                Stampe.stampaTurno(giocatori, turno);
                if (!Tavoliere.presenzaMosseDisponibili(tav, turno) && !tav.finePartita()) {
                    turno = Comandi.altroGiocatore(turno);
                    Stampe.stampaPassaggioTurno();
                    continue;
                }
                if (tav.finePartita()) { //gestisce la fine di una partita
                    if (tav.partitaPareggiata()) {
                        Stampe.stampaPartitaPareggiata(tav);
                    } else {
                        Stampe.stampaFinePartita(giocatori, tav);
                    }
                    partitaIniziata = false;
                    tav = new Tavoliere();
                    turno = 0;
                    listaMosse = new ArrayList<>();
                }
            }

            //lettura comando
            Stampe.stampaInserireComando();
            String comando = Tastiera.readString();
            if (comando != null) {
                if (comandiAiuto.contains(comando)) {
                    Stampe.stampaComandi();
                }
                if ("/esci".equals(comando)) {
                    loop = Comandi.comandoEsci();
                }
                if ("/gioca".equals(comando) && tav != null) {
                    if (!partitaIniziata) {
                        Tavoliere.inizializzaTavoliere(tav);
                        giocatori[0] = setNome(1);
                        giocatori[1] = setNome(2);
                        System.out.println(tav);
                        partitaIniziata = true;
                    } else {
                        Stampe.stampaPartitaGiaInCorso();
                    }
                }
                if ("/abbandona".equals(comando)) {
                    partitaIniziata = Comandi.comandoAbbandona(
                            partitaIniziata, tav, giocatori[Comandi.altroGiocatore(turno)], turno);
                    if (!partitaIniziata) {
                        tav = new Tavoliere();
                        turno = 0;
                        listaMosse = new ArrayList<>();
                    }
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
                if ("/mosse".equals(comando)) {
                    if (partitaIniziata) {
                        for (String mossa : listaMosse) {
                            System.out.print(mossa);
                        }
                    } else {
                        Stampe.stampaConsigliaGioca();
                    }
                }
                // Comando movimento.
                if (partitaIniziata && Tastiera.inputValido(comando, partitaIniziata)) {
                    int[] mosse = Tastiera.separaInput(comando);
                    if (tav != null  && giocatori[turno].controllaMossa(tav, mosse, turno)) {
                        Tavoliere.collezionaMosse(listaMosse, comando, turno, giocatori);
                        tav = giocatori[turno].mossaGiocatore(tav, mosse, turno);
                        tav = tav.conquistaPedine(mosse, turno);
                        turno = Comandi.altroGiocatore(turno);
                        Comandi.comandoTavoliere(partitaIniziata, tav);
                    }
                }
                //controllo comandi errati.
                if (!comandi.contains(comando) && !comandiAiuto.contains(comando)
                    && !Tastiera.inputValido(comando, partitaIniziata)) {
                    Stampe.stampaErroreComando();
                }
            }
        }
    }
}
