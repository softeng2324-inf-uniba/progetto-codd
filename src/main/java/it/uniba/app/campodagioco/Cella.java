package it.uniba.app.campodagioco;
/**
 * <<ENTITY>>
 * Classe che gestisce le celle che compongono il tabellone.
 */
public class Cella {
    private int idCasella; //libera, giocatore1, giocatore2, bloccata.

    /**
     * Metodo Costruttore della classe Cella.
     */
    Cella() {
        this.idCasella = 2;
    }
    /**
     * Metodo Costruttore della classe Cella.
     * @param id intero da inserire.
     */
    public Cella(final int id) {
        this.idCasella = id;
    }

    /**
     * Metodo che permette l'inserimento del valore id in una casella.
     * @param id valore da inserire.
     */
    public void setId(final int id) {
        this.idCasella = id;
    }

    /**
     * Metodo che restituisce l'id della casella.
     * @return intero letto.
     */
    public int getId() {
        return this.idCasella;
    }
}
