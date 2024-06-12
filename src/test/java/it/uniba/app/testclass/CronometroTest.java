package it.uniba.app.testclass;

import org.junit.jupiter.api.Test;
import it.uniba.app.utilita.Cronometro;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;

/**
 * Test per la classe Cronometro.
*/
class CronometroTest {
    private Cronometro cronometro;

    @BeforeEach
    void setUp() {
        cronometro = new Cronometro();
    }

    @Test
    void testAvvioCronometroGiaAvviato() {
        cronometro.avvioCronometro();
        assertThrows(IllegalStateException.class, () -> cronometro.avvioCronometro());
    }

    /**
     * Test per il metodo getTempo.
    */
    @Test
    void testGetTempo() {
        cronometro.avvioCronometro();
        String tempo = cronometro.getTempo();
        assertNotNull(tempo);
        assertTrue(tempo.matches("\\d{2}:\\d{2}:\\d{2}"));
    }

    /**
     * Test per il metodo getTempo senza aver avviato il cronometro.
    */
    @Test
    void testGetTempoNoAvvio() {
        assertThrows(IllegalStateException.class, () -> cronometro.getTempo());
    }

    /**
     * Test per il simulare l'avvio del cronometro ed attesa di 5 secondi.
    */
    @Test
    void testGetTempoSleep() {
        final int cinqueSecondi = 5000;
        cronometro.avvioCronometro();
        // Simuliamo il passaggio di 5 secondi
        try {
            Thread.sleep(cinqueSecondi);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String tempo = cronometro.getTempo();
        assertNotNull(tempo);
    }
}
