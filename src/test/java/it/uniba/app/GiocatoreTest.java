package it.uniba.app.testclass;

import it.uniba.app.campodagioco.Tavoliere;
import it.uniba.app.utente.Giocatore;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
* Classe per i test della classe Giocatore.
*/
public class GiocatoreTest {

    /**
     * Test per il metodo controllaMossa.
    */
    @Test
    void testControllaMossaValidaMaxDistanza() {
        final int pos0 = 0;
        final int pos1 = 1;
        Tavoliere tav = new Tavoliere();
        int[] mossa = {pos0, pos0, pos1, pos1};
        Giocatore giocatore = new Giocatore("Player1");
        assertFalse(giocatore.controllaMossa(tav, mossa, Tavoliere.PG1));
    }

    /**
     * Test per il metodo controllaMossa.
    */
    @Test
    void testControllaMossaDistanzaZero() {
        final int pos0 = 0;
        Tavoliere tav = new Tavoliere();
        int[] mossa = {pos0, pos0, pos0, pos0};
        Giocatore giocatore = new Giocatore("Player1");
        assertFalse(giocatore.controllaMossa(tav, mossa, Tavoliere.PG1));
    }

    /**
     * Test per il metodo controllaMossa.
    */
    @Test
    void testControllaMossaDiagonale() {
        final int pos0 = 0;
        final int pos1 = 1;
        Tavoliere tav = new Tavoliere();
        int[] mossa = {pos0, pos0, pos1, pos1};
        Giocatore giocatore = new Giocatore("Player1");
        assertFalse(giocatore.controllaMossa(tav, mossa, Tavoliere.PG1));
    }

    /**
     * Test per il metodo controllaMossa.
    */
    @Test
    void testControllaMossaNonValidaCellaNonAppartenenteAlGiocatore() {
        final int pos0 = 0;
        final int pos1 = 1;
        Tavoliere tav = new Tavoliere();
        int[] mossa = {pos0, pos0, pos1, pos1};
        Giocatore giocatore = new Giocatore("Player1");
        assertFalse(giocatore.controllaMossa(tav, mossa, Tavoliere.PG2));
    }

    /**
     * Test per il metodo controllaMossa.
    */
    @Test
    void testControllaMossaEntroDistanzaMax() {
        final int pos0 = 0;
        final int pos3 = 3;
        Tavoliere tav = new Tavoliere();
        int[] mossa = {pos0, pos0, pos3, pos3};
        Giocatore giocatore = new Giocatore("Player1");
        assertFalse(giocatore.controllaMossa(tav, mossa, Tavoliere.PG1));
    }

    /**
     * Test per il metodo controllaMossa.
    */
    @Test
    void testControllaMossaMossaNonValidaCellaNonVuota() {
        final int pos0 = 0;
        final int pos1 = 1;
        Tavoliere tav = new Tavoliere();
        tav.setIdTav(1, 1, Tavoliere.PG2);
        int[] mossa = {pos0, pos0, pos1, pos1};
        Giocatore giocatore = new Giocatore("Player1");
        assertFalse(giocatore.controllaMossa(tav, mossa, Tavoliere.PG1));
    }

    /**
     * Test per il metodo controllaMossa.
    */
    @Test
    void testControllaMossaMossaOltreBordo() {
        final int pos0 = 0;
        final int posminus1 = -1;
        Tavoliere tav = new Tavoliere();
        int[] mossa = {pos0, pos0, posminus1, posminus1};
        Giocatore giocatore = new Giocatore("Player1");
        assertFalse(giocatore.controllaMossa(tav, mossa, Tavoliere.PG1));
    }

    /**
     * Test per il metodo controllaMossa.
    */
    @Test
    void testMossaGiocatoreMossaDiagonaleValida() {
        final int pos2 = 2;
        final int pos1 = 1;
        Tavoliere tav = new Tavoliere();
        int[] mossa = {pos1, pos1, pos2, pos2};
        Giocatore giocatore = new Giocatore("Player1");
        Tavoliere tavUpdated = giocatore.mossaGiocatore(tav, mossa, Tavoliere.PG1);
        assertEquals(Tavoliere.PG1, tavUpdated.getIdTav(2, 2));
}

    /**
     * Test per il metodo controllaMossa.
    */
    @Test
    void testMossaGiocatoreMossaNellaDistanzaMax() {
        final int pos0 = 0;
        final int pos1 = 1;
        Tavoliere tav = new Tavoliere();
        int[] mossa = {pos0, pos0, pos1, pos1};
        Giocatore giocatore = new Giocatore("Player1");
        Tavoliere tavUpdated = giocatore.mossaGiocatore(tav, mossa, Tavoliere.PG1);
        assertEquals(Tavoliere.PG1, tavUpdated.getIdTav(pos1, pos1));
    }

    /**
     * Test per il metodo controllaMossa.
    */
    @Test
    void testMossaGiocatoreNumPedineAggiornato() {
        final int pos0 = 0;
        final int pos1 = 1;
        Tavoliere tav = new Tavoliere();
        int[] mossa = {pos0, pos0, pos1, pos1};
        Giocatore giocatore = new Giocatore("Player1");
        Tavoliere tavUpdated = giocatore.mossaGiocatore(tav, mossa, Tavoliere.PG1);
        assertEquals(1, tavUpdated.getPedine(Tavoliere.PG1));
    }

    /**
     * Test per il metodo controllaMossa.
    */
    @Test
    void testControllaMossaOrizzontale() {
        final int pos0 = 0;
        final int pos1 = 1;
        Tavoliere tav = new Tavoliere();
        int[] mossa = {pos0, pos0, pos0, pos1};
        Giocatore giocatore = new Giocatore("Player1");
        assertFalse(giocatore.controllaMossa(tav, mossa, Tavoliere.PG1));
    }

    /**
     * Test per il metodo mossaGiocatore.
    */
    @Test
    void testMossaGiocatoreMoveExceedsMaxDistance() {
        final int pos0 = 0;
        final int pos3 = 3;
        Tavoliere tav = new Tavoliere();
        int[] mossa = {pos0, pos0, pos3, pos3};
        Giocatore giocatore = new Giocatore("Player1");
        Tavoliere tavUpdated = giocatore.mossaGiocatore(tav, mossa, Tavoliere.PG1);
        assertEquals(Tavoliere.CAS_VUOTA, tavUpdated.getIdTav(0, 0));
    }

    /**
     * Test per il metodo mossaGiocatore.
    */
    @Test
    void testMossaGiocatoreMossaVerticale() {
        final int pos0 = 0;
        final int pos1 = 1;
        Tavoliere tav = new Tavoliere();
        int[] mossa = {pos0, pos0, pos1, pos0};
        Giocatore giocatore = new Giocatore("Player1");
        Tavoliere tavUpdated = giocatore.mossaGiocatore(tav, mossa, Tavoliere.PG1);
        assertEquals(Tavoliere.PG1, tavUpdated.getIdTav(0, 1));
    }

    /**
     * Test per il metodo mossaGiocatore.
    */
    @Test
    void testMossaGiocatorePedineStessoNumeroDistanzaMassima() {
        final int pos0 = 0;
        final int pos1 = 1;
        Tavoliere tav = new Tavoliere();
        tav.setPedine(Tavoliere.PG1, 1);
        int[] mossa = {pos0, pos0, pos1, pos1};
        Giocatore giocatore = new Giocatore("Player1");
        Tavoliere tavUpdated = giocatore.mossaGiocatore(tav, mossa, Tavoliere.PG1);
        assertEquals(2,
            tavUpdated.getPedine(Tavoliere.PG1));
    }

    /**
     * Test per il metodo mossaGiocatore.
    */
    @Test
    void testMossaGiocatoreIncrementaPedineNuovaPedina() {
        final int pos0 = 0;
        final int pos1 = 1;
        Tavoliere tav = new Tavoliere();
        tav.setPedine(Tavoliere.PG1, 1);
        int[] mossa = {pos0, pos0, pos1, pos1};
        Giocatore giocatore = new Giocatore("Player1");
        Tavoliere tavUpdated = giocatore.mossaGiocatore(tav, mossa, Tavoliere.PG1);
        assertEquals(2, tavUpdated.getPedine(Tavoliere.PG1));
    }
}
