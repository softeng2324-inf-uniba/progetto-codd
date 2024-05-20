package it.uniba.app;
/**
 * <<ENTITY>>
 * Classe del giocatore.
 */
public class Giocatore {
    private final String nome;

    /**
     * Metodo del costruttore di Giocatore.
     * @param n nome del giocatore.
     */
    Giocatore(final String n) {
        this.nome = n;
    }

    /**
     * Metodo che restituisce il nome del giocatore.
     * @return stringa contenente il nome.
     */
    public String getNome() {
        return this.nome;
    }
}
