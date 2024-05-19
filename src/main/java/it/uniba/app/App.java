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
     * Entrypoint of the application.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        System.out.println(new App().getGreeting());
        System.out.println("digita \u001B[1m/help\u001B[0m");
        Set<String> comandiAiuto = Set.of("/help", "-h", "--help");
        boolean loop = true;
        while (loop) {
            Stampe.stampaInserireComando();
            String comando = Tastiera.readString();
            if (comando != null) {
                if (comandiAiuto.contains(comando)) {
                    Stampe.stampaComandi();
                } else {
                    Stampe.stampaErrore();
                }
            }
        }
    }
}
