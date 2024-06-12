package it.uniba.app.testclass;

import it.uniba.app.campodagioco.Tavoliere;
import it.uniba.app.utente.Giocatore;
import it.uniba.app.utilita.Stampe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Classe per i test della classe Stampe.
 */
public class StampeTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    /**
     * Test.
     */
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor, true, StandardCharsets.UTF_8));
    }

    /**
     * Test.
     */
    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    /**
     * Test per il metodo stampaConsigliaAiuto.
     */
    @Test
    public void testStampaConsigliaAiuto() {
        Stampe.stampaConsigliaAiuto();
        assertEquals("digita \u001B[1m/help\u001B[0m", outputStreamCaptor.toString(StandardCharsets.UTF_8).trim());
    }

    /**
     * Test per il metodo stampaPassaggioTurno.
     */
    @Test
    public void testStampaPassaggioTurno() {
        Stampe.stampaPassaggioTurno();
        assertEquals("Il giocatore non ha mosse possibili, il turno passa all'avversario",
                outputStreamCaptor.toString(StandardCharsets.UTF_8).trim());
    }

    /**
     * Test per il metodo stampaTempoTrascorso.
     */
    @Test
    public void testStampaTempoTrascorso() {
        Stampe.stampaTempoTrascorso("00:10");
        assertEquals("Tempo trascorso: 00:10", outputStreamCaptor.toString(StandardCharsets.UTF_8).trim());
    }

    /**
     * Test per il metodo stampaErroreBlocco.
     */
    @Test
    public void testStampaErroreBlocco() {
        Stampe.stampaErroreBlocco();
        assertEquals("Casella già bloccata", outputStreamCaptor.toString(StandardCharsets.UTF_8).trim());
    }

    /**
     * Test per il metodo stampaPartitaPareggiata.
     */
    @Test
    public void testStampaPartitaPareggiata() {
        final int pedina10 = 10;
        Tavoliere tav = new Tavoliere();
        tav.setPedine(0, pedina10);
        tav.setPedine(1, pedina10);
        Stampe.stampaPartitaPareggiata(tav);
        assertEquals("La partita è finita in pareggio: 10 a 10",
            outputStreamCaptor.toString(StandardCharsets.UTF_8).trim());
    }

    /**
     * Test per il metodo stampaTurno.
     */
    @Test
    public void testStampaTurno() {
        Giocatore[] giocatori = {new Giocatore("Test1"), new Giocatore("Test2")};
        Stampe.stampaTurno(giocatori, 0);
        assertEquals("Turno di \u001B[94mTest1\u001B[0m", outputStreamCaptor.toString(StandardCharsets.UTF_8).trim());
    }

    /**
     * Test per il metodo stampaErroreComando.
     */
    @Test
    public void testStampaErroreComando() {
        Stampe.stampaErroreComando();
        assertEquals("comando non accettato", outputStreamCaptor.toString(StandardCharsets.UTF_8).trim());
    }

    /**
     * Test per il metodo stampaErroreAbbandono.
     */
    @Test
    public void testStampaErroreAbbandono() {
        Stampe.stampaErroreAbbandono();
        assertEquals("Non c'è nessuna partita in corso", outputStreamCaptor.toString(StandardCharsets.UTF_8).trim());
    }

    /**
     * Test per il metodo stampaErroreAbbandono2.
     */
    @Test
    public void testStampaErroreAbbandono2() {
        Stampe.stampaErroreAbbandono2();
        assertEquals("La partita prosegue", outputStreamCaptor.toString(StandardCharsets.UTF_8).trim());
    }
}
