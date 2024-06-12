package it.uniba.app.testclass;

import it.uniba.app.campodagioco.Cella;
import it.uniba.app.campodagioco.Tavoliere;
import it.uniba.app.utente.Giocatore;
import org.junit.jupiter.Before;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
* Classe per i test della classe Tavoliere.
*/
public class TavoliereTest {
    @Before
    void setUp() {
      new Tavoliere();
    }

    @Test
    void testBloccaCasella() {
        Tavoliere tav = new Tavoliere();
        int[] coordinate = {0, 0};
        tav.bloccaCasella(tav, coordinate);
        assertEquals(Tavoliere.CAS_BLOCCO, tav.getIdTav(0, 0));
    }

    /**
     * Test per la funzione CollezionaMosse.
     */
    @Test
    void testCollezionaMosse() {
        List<String> mosse = new ArrayList<>();
        Giocatore[] giocatori = {new Giocatore("Giocatore1"), new Giocatore("Giocatore2")};
        Tavoliere.collezionaMosse(mosse, "A1", 0, giocatori);
        assertFalse(mosse.isEmpty());
        assertTrue(mosse.get(0).contains("Giocatore1"));
    }

    /**
     * Test per la funzione ConquistaPedine.
     */
    @Test
    void testConquistaPedine() {
        Tavoliere tav = new Tavoliere();
        Tavoliere.inizializzaTavoliere(tav);
        int[] mosse = {1, 1, 2, 2};
        tav.conquistaPedine(mosse, Tavoliere.PG1);
        assertEquals(Tavoliere.PG1, tav.getIdTav(0, 0));
    }

    /**
     * Test per la funzione FinePartita.
     */
    @Test
    void testFinePartita() {
        Tavoliere tav = new Tavoliere();
        tav.setPedine(Tavoliere.PG1, 0);
        assertTrue(tav.finePartita());
    }

    /**
     * Test per la funzione GetIdTav.
     */
    @Test
    void testGetIdTav() {
        Tavoliere tav = new Tavoliere();
        assertEquals(Tavoliere.CAS_VUOTA, tav.getIdTav(0, 0));
    }

    /**
     * Test per la funzione GetPedine.
     */
    @Test
    void testGetPedine() {
        final int pedina3 = 3;
        Tavoliere tav = new Tavoliere();
        tav.setPedine(Tavoliere.PG1, pedina3);
        assertEquals(pedina3, tav.getPedine(Tavoliere.PG1));
    }

    /**
     * Test per la funzione InizializzaTavoliere.
     */
    @Test
    void testInizializzaTavoliere() {
        Tavoliere tav = new Tavoliere();
        Tavoliere.inizializzaTavoliere(tav);
        assertEquals(Tavoliere.PG1, tav.getIdTav(0, 0));
        assertEquals(Tavoliere.PG2, tav.getIdTav(0, Tavoliere.DIM_TAV - 1));
    }

    /**
     * Test per la funzione PartitaPareggiata.
     */
    @Test
    void testPartitaPareggiata() {
        final int pedina3 = 3;
        Tavoliere tav = new Tavoliere();
        tav.setPedine(Tavoliere.PG1, pedina3);
        tav.setPedine(Tavoliere.PG2, pedina3);
        assertTrue(tav.partitaPareggiata());
    }

    /**
     * Test per la funzione PresenzaMosseDisponibili.
     */
    @Test
    void testPresenzaMosseDisponibili() {
        Tavoliere tav = new Tavoliere();
        Tavoliere.inizializzaTavoliere(tav);
        assertTrue(Tavoliere.presenzaMosseDisponibili(tav, Tavoliere.PG1));
    }

    /**
     * Test per la funzione QualiMosse.
     */
    @Test
    void testQualiMosse() {
        Tavoliere tav = new Tavoliere();
        Tavoliere.inizializzaTavoliere(tav);
        tav.qualiMosse(Tavoliere.PG1);
        // Verifica che il metodo non lanci eccezioni e che il tavoliere sia stato stampato
        assertNotNull(tav.toString());
    }

    /**
     * Test per la funzione SetIdTav.
     */
    @Test
    void testSetIdTav() {
        final int pos0 = 0;
        Tavoliere tav = new Tavoliere();
        tav.setIdTav(pos0, pos0, Tavoliere.PG1);
        assertEquals(Tavoliere.PG1, tav.getIdTav(pos0, pos0));
    }

    /**
     * Test per la funzione setPedine.
     */
    @Test
    void testSetPedine() {
        final int pedina5 = 5;
        Tavoliere tav = new Tavoliere();
        tav.setPedine(Tavoliere.PG1, pedina5);
        assertEquals(pedina5, tav.getPedine(Tavoliere.PG1));
    }

    /**
     * Test per la funzione StampaTabelloneVuoto.
     */
    @Test
    void testStampaTabelloneVuoto() {
        String rigaFinale = "a b c d e f g";
        String tabelloneVuoto = Tavoliere.stampaTabelloneVuoto();
        assertNotNull(tabelloneVuoto);
        assertTrue(tabelloneVuoto.contains(rigaFinale));
    }

    /**
     * Test per la funzione ToString.
     */
    @Test
    void testToString() {
        Tavoliere tav = new Tavoliere();
        assertNotNull(tav.toString());
    }

    /**
     * Test per la funzione ToString2.
     */
    @Test
    void testToString2() {
        Tavoliere tav = new Tavoliere();
        Cella[][] tavCopy = new Cella[Tavoliere.DIM_TAV][Tavoliere.DIM_TAV];
        for (int i = 0; i < Tavoliere.DIM_TAV; i++) {
            for (int j = 0; j < Tavoliere.DIM_TAV; j++) {
                tavCopy[i][j] = new Cella(tav.getIdTav(i, j));
            }
        }
        assertNotNull(tav.toString(tavCopy));

    }

    /**
     * Test per la funzione setIdTav.
     */
    @Test
    void testSbloccaCasella() {
        final int pos0 = 0;
        Tavoliere tav = new Tavoliere();
        tav.setIdTav(pos0, pos0, Tavoliere.CAS_BLOCCO);
        assertEquals(Tavoliere.CAS_BLOCCO, tav.getIdTav(pos0, pos0));

        tav.setIdTav(pos0, pos0, Tavoliere.CAS_VUOTA);
        assertEquals(Tavoliere.CAS_VUOTA, tav.getIdTav(pos0, pos0));
    }

    /**
     * Test per la funzione setIdTav.
     */
    @Test
    void testSetPedineLimiteInferiore() {
        final int pos0 = 0;
        Tavoliere tav = new Tavoliere();
        tav.setPedine(Tavoliere.PG1, pos0);
        assertEquals(pos0, tav.getPedine(Tavoliere.PG1));
    }
}
