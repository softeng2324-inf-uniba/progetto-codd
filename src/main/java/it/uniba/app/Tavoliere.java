package it.uniba.app;
/**
 * <<ENTITY>>.
 * Classe che rappresenta il tavolo da gioco
 */

public class Tavoliere {
    public static final int DIM_TAV = 7;
    public static final int CAS_VUOTA = 0;
    public static final int CAS_PG1 = 1;
    public static final int CAS_PG2 = 2;
    public static final int CAS_GIAL = 3;
    public static final int CAS_ARAN = 4;
    public static final int CAS_ROSA = 5;

    private final Cella[][] tavoliere;
    /**
     * Costruttore di Tavoliere.
     */
    public Tavoliere() {
        tavoliere = new Cella[DIM_TAV][DIM_TAV];
        for (int i = 0; i < DIM_TAV; i++) {
            for (int j = 0; j < DIM_TAV; j++) {
                tavoliere[i][j] = new Cella();
            }
        }
    }

    /**
     * Metodo che inizializza il tavoliere aggiungendo le pedine iniziali.
     * @param tav Tavoliere da inizializzare
     * @return Tavoliere inizializzato
     */
    public static Tavoliere inizializzaTavoliere(final Tavoliere tav) {
        if (tav.eVuota(tav.tavoliere)) {
            tav.tavoliere[0][0].setId(CAS_PG1);
            tav.tavoliere[0][DIM_TAV - 1].setId(CAS_PG2);
            tav.tavoliere[DIM_TAV - 1][0].setId(CAS_PG2);
            tav.tavoliere[DIM_TAV - 1][DIM_TAV - 1].setId(CAS_PG1);
        } else {
            System.out.println("Impossibile iniziare Nuova Partita");
        }
        return tav;
    }

    /**
     * Metodo che verifica se il tavoliere è vuoto.
     * @param tav matrice che rappresenta il tavoliere
     * @return boolean
     */
    private boolean eVuota(final Cella[][] tav) {
        for (int i = 0; i < DIM_TAV; i++) {
            for (int j = 0; j < DIM_TAV; j++) {
                if (tav[i][j].getId() != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Metodo che stampa a video un tabellone vuoto.
     * @return tavoliere stampato
     */
    public static String stampaTabelloneVuoto() {
        Tavoliere tav = new Tavoliere();
        String str;
        str = tav.toString();
        return str;
    }
    /**
     * Metodo che costruisce la stringa del tavoliere.
     * @return stringa da stampare
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        int x = 0;
        str.append("   a b c d e f g\n");
        for (int i = 0; i < DIM_TAV; i++) {
            str.append((i + 1)).append("|");
            for (int j = 0; j < DIM_TAV; j++) {
                if (tavoliere[i][j].getId() == CAS_PG1) {
                    str.append("⚫");
                    x++;
                } else if (tavoliere[i][j].getId() == CAS_PG2) {
                    str.append("⚪");
                    x++;
                } else if (tavoliere[i][j].getId() == CAS_VUOTA) {
                    if (x % 2 == 0) {
                        str.append("░░");
                    } else {
                        str.append("▓▓");
                    }
                    x++;
                }
            }
            str.append("|").append(i + 1).append("\n");
        }
        str.append("   a b c d e f g");
        return str.toString();
        }
}

