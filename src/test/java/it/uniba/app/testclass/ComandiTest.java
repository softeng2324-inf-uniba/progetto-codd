package it.uniba.app.testclass;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import it.uniba.app.campodagioco.Tavoliere;
import it.uniba.app.utente.Giocatore;
import it.uniba.app.utilita.Comandi;

/**
 * Classe per i test della classe Comandi.
 */
class ComandiTest {
    /**
     * Test per il metodo AltroGiocatore.
     */
    @Test
    public void testAltroGiocatore() {
        assertEquals(1, Comandi.altroGiocatore(0));
        assertEquals(0, Comandi.altroGiocatore(1));
    }

    /**
     * Test per il metodo comandoAbbandona quando la partita non è iniziata.
     */
    @Test
    public void testComandoAbbandonaPartitaNonIniziata() {
        Giocatore giocatore = new Giocatore("test");
        assertFalse(Comandi.comandoAbbandona(false, new Tavoliere(), giocatore, 0));
    }

    /**
     * Test per il metodo comandoTavoliere quando la partita non è iniziata.
     */
    @Test
    public void testComandoTavolierePartitaNonIniziata() {
        Giocatore[] giocatori = new Giocatore[2];
        // Verifica che venga chiamato il metodo di stampa quando la partita non è iniziata
        Comandi.comandoTavoliere(false, new Tavoliere(), giocatori);
        // Assuming Stampe.stampaConsigliaGioca prints something to the console
        // No direct way to test without mocking, this part needs adjustment in the main codebase to be testable
    }

    /**
     * Test per il metodo comandoQualiMosse quando la partita non è iniziata.
     */
    @Test
    public void testComandoQualiMossePartitaNonIniziata() {
        Comandi.comandoQualiMosse(false, new Tavoliere(), 0);
        // Assuming Stampe.stampaConsigliaGioca prints something to the console
        // No direct way to test without mocking, this part needs adjustment in the main codebase to be testable
    }

    /**
     * Test per il metodo comandoQualiMosse quando la partita è iniziata.
     */
    @Test
    public void testComandoQualiMossePartitaIniziata() {
        Tavoliere tavoliere = new Tavoliere();
        int turnoGiocatore = 1;
        Comandi.comandoQualiMosse(true, tavoliere, turnoGiocatore);
        // Assuming Tavoliere.qualiMosse does something we can check
        // No direct way to test without mocking, this part needs adjustment in the main codebase to be testable
    }
}