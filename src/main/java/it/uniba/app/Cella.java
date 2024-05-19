package it.uniba.app;
/**
 * <<ENTITY>>
 * Classe che gestisce le celle che compongono il tabellone.
 */
public class Cella {
    private int idCasella;
    // da aggiungere dopo ma che per colpa del checkstyle.
    // non si possono aggiungere le altre funzioni poichè non utilizzate.

    /**
     * Metodo Costruttore della classe Cella.
     */
    Cella() {
        this.idCasella = 0;
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
