package it.uniba.app.utilita;
import java.time.Duration;
import java.time.LocalTime;

/**
 * <<CONTROLL>>
 * Metodo che gestisce il cronometro nella partita.
 */
public class Cronometro {
    private LocalTime avviaTempo;
    private boolean avviato;

    /**
     * Metodo costruttore.
     */
    public Cronometro() {
        this.avviato = false;
    }

    /**
     * Metodo che serve ad avviare il cronometro.
     */
    public void avvioCronometro() {
        if (!avviato) {
            this.avviaTempo = LocalTime.now();
            this.avviato = true;
        } else {
            throw new IllegalStateException("Il cronometro è già avviato");
        }
    }

    /**
     * Metodo per ottenere il tempo trascorso nel formato hh:mm:ss.
     * @return tempo.
     */
    public String getTempo() {
        final int convertiTempo = 60;
        if (avviato) {
            Duration elapsed = Duration.between(avviaTempo, LocalTime.now());
            long ore = elapsed.toHours();
            long minuti = elapsed.toMinutes() % convertiTempo;
            long secondi = elapsed.getSeconds() % convertiTempo;
            return String.format("%02d:%02d:%02d", ore, minuti, secondi);
        } else {
            throw new IllegalStateException("Il cronometro non è avviato");
        }
    }
}
