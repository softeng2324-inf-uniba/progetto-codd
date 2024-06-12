package it.uniba.app.testclass;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


import it.uniba.app.App;

/**
 * Test della classe App.
 */
class AppTest {
    /**
     * Test del metodo getGreeting.
     */
    @Test
    public void testGetGreeting() {
        App app = new App();
        String expectedGreeting = """
                \033[38;5;208m\
                ░█████╗░ ████████╗ ░█████╗░ ██╗░░██╗ ██╗░░██╗
                ██╔══██╗ ╚══██╔══╝ ██╔══██╗ ╚██╗██╔╝ ╚██╗██╔╝
                ███████║ ░░░██║░░░ ███████║ ░╚███╔╝░ ░╚███╔╝░
                ██╔══██║ ░░░██║░░░ ██╔══██║ ░██╔██╗░ ░██╔██╗░
                ██║░░██║ ░░░██║░░░ ██║░░██║ ██╔╝╚██╗ ██╔╝╚██╗
                ╚═╝░░╚═╝ ░░░╚═╝░░░ ╚═╝░░╚═╝ ╚═╝░░╚═╝ ╚═╝░░╚═╝\u001B[0m
                """;

        assertEquals(expectedGreeting, app.getGreeting());
    }
}
