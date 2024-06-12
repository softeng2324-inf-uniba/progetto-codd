package it.uniba.app.testclass;

import it.uniba.app.utilita.Tastiera;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
* Classe per i test della classe Tastiera.
*/
public class TastieraTest {
    private final InputStream originalSystemIn = System.in;
    private static final String TESTINPUT = "Test input";

    /**
     * Funzione di inizializzazione.
     */
    @BeforeEach
    public void setUp() {
        System.setIn(new ByteArrayInputStream(TESTINPUT.getBytes(StandardCharsets.UTF_8)));
    }

    /**
     * Funzione di inizializzazione.
     */
    @AfterEach
    public void tearDown() {
        System.setIn(originalSystemIn);
    }

    /**
     * Test per la funzione BloccoValidoIncorrectCoordinates.
     */
    @Test
    public void testBloccoValidoLengthNotEqual() {
        String input = "/blocca 12";
        assertFalse(Tastiera.bloccoValido(input));
        input = "/blocca 5";
        assertFalse(Tastiera.bloccoValido(input));
        input = "/blocca ";
        assertFalse(Tastiera.bloccoValido(input));
    }

    /**
     * Test per la funzione BloccoValidoIncorrectCoordinates.
     */
    @Test
    public void testBloccoValidoNotStartingWithBlocca() {
        String input = "/sblocca 12,12";
        assertFalse(Tastiera.bloccoValido(input));
        input = "blocca a3";
        assertFalse(Tastiera.bloccoValido(input));
    }

    /**
     * Test per la funzione BloccoValidoIncorrectCoordinates.
     */
    @Test
    public void testBloccoValidoIncorrectCoordinates() {
        String[] input = new String[] {
                "/blocca a1", "/blocca a2", "/blocca a3", "/blocca a7", "/blocca a6", "/blocca a5",
                "/blocca b1", "/blocca b2", "/blocca b3", "/blocca b7", "/blocca b6", "/blocca b5",
                "/blocca c1", "/blocca c2", "/blocca c3", "/blocca c7", "/blocca c6", "/blocca c5",
                "/blocca g1", "/blocca g2", "/blocca g3", "/blocca g7", "/blocca g6", "/blocca g5",
                "/blocca f1", "/blocca f2", "/blocca f3", "/blocca f7", "/blocca f6", "/blocca f5",
                "/blocca e1", "/blocca e2", "/blocca e3", "/blocca e7", "/blocca e6", "/blocca e5" };
        for (String object : input) {
            assertFalse(Tastiera.bloccoValido(object));
        }
    }

    /**
     * Test per la funzione BloccoValidoCorrectInput.
     */
    @Test
    public void testBloccoValidoCorrectInput() {
        String[] input = new String[] {
                "/blocca d1", "/blocca d2", "/blocca d3", "/blocca d7",
                "/blocca d6", "/blocca d5", "/blocca d4",
                "/blocca a4", "/blocca b4", "/blocca c4", "/blocca d4",
                "/blocca d5", "/blocca d6", "/blocca d7", "/blocca d8" };
        for (String object : input) {
            assert (Tastiera.bloccoValido(object));
        }
    }

    /**
     * Test per verificare se la funzione SalvaCoordinateBlocca restituisce il valore atteso.
     */
    @Test
    public final void testSalvaCoordinateBloccoAccettato() {
        String[] input = new String[] {
                    "/blocca d1", "/blocca d2", "/blocca d3", "/blocca d7",
                    "/blocca d6", "/blocca d5", "/blocca d4",
                    "/blocca a4", "/blocca b4", "/blocca c4", "/blocca d4",
                    "/blocca d5", "/blocca d6", "/blocca d7", "/blocca d8"};
        for (String object : input) {
            int[] result = Tastiera.salvaCoordinateBlocco(object);
            assertNotNull(result, "Result should not be null");
            assertEquals(2, result.length, "Result should have a length of 2");
            for (int coordinate : result) {
                assertTrue(coordinate >= 0, "Each coordinate should be a non-negative integer");
            }
        }
    }

    /**
     * Test per verificare se la funzione SalvaCoordinateBlocco blocca i comandi non accettati.
     */
    @Test
    public final void testSalvaCoordinateBloccoRifiutato() {
        String[] input = new String[]{
            "/blocca a", "/blocca 4", "/blocca ac3", "/blocca a79", "/blocca a6", "/blocca a5" };
        for (String object : input) {
            try {
                Tastiera.salvaCoordinateBlocco(object);
            } catch (Exception e) {
                assertNotNull(e);
            }
        }
    }

    /**
     * Test per la funzione InputValido.
     */
    @Test
    public void testInputValido() {
        // verifico con input corretto
        String[] input = new String[]{
            "a1-b2", "a4-c4", "c4-c5", "a1-a2", "g1-f2"};
        for (String object : input) {
            assertTrue(Tastiera.inputValido(object, true));
        }
        // verifico con input errato
        input = new String[]{
            "/blocca 4", "/blocca ac3", "/blocca a79", "/blocca a6", "/blocca a5", "a1 b2", "a1-b3-" };
        for (String object : input) {
            assertFalse(Tastiera.inputValido(object, true));
        }
    }

    /**
     * Test per la funzione SeparaInput.
     */
    @Test
    public void testSeparaInput() {
        final int pos0 = 0;
        final int pos1 = 1;
        final int pos2 = 2;
        final int pos3 = 3;
        final int pos4 = 4;
        assertArrayEquals(new int[]{pos0, pos0, pos1, pos1}, Tastiera.separaInput("a1-b2"));
        assertArrayEquals(new int[]{pos1, pos2, pos3, pos4}, Tastiera.separaInput("b3-d5"));

        String[] input = new String[] {"a-b2", "c4-", "g-2", "a12"};
        for (String object: input) {
            assertThrows(StringIndexOutOfBoundsException.class, () -> {
                Tastiera.separaInput(object);
            });
        }
    }
}
